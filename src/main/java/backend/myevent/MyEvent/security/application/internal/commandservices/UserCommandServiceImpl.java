package backend.myevent.MyEvent.security.application.internal.commandservices;

import backend.myevent.MyEvent.security.application.internal.outhboundedservices.hashing.HashingService;
import backend.myevent.MyEvent.security.application.internal.outhboundedservices.tokens.TokenService;
import backend.myevent.MyEvent.security.domain.models.aggregates.User;
import backend.myevent.MyEvent.security.domain.models.commands.SignInCommand;
import backend.myevent.MyEvent.security.domain.models.commands.SignUpCommand;
import backend.myevent.MyEvent.security.domain.services.UserCommandService;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByCorreo(command.correo());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByCorreo(command.correo()))
            throw new RuntimeException("Username already exists");
        var roles = command.roles().stream().map(role -> roleRepository.findByName(role.getName()).orElseThrow(() -> new RuntimeException("Role name not found"))).toList();
        var user = new User(
                command.name(),
                command.surname(),
                command.correo(),
                hashingService.encode(command.password()),
                command.phone(),
                command.dni(),
                command.tipoDeCuenta(),
                command.premium(),
                roles
        );
        userRepository.save(user);
        return userRepository.findByCorreo(command.correo());
    }
}
