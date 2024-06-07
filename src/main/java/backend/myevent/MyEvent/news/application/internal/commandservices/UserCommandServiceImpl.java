package backend.myevent.MyEvent.news.application.internal.commandservices;

import backend.myevent.MyEvent.news.domain.model.aggregates.User;
import backend.myevent.MyEvent.news.domain.model.commands.CreateUserCommand;
import backend.myevent.MyEvent.news.domain.services.UserCommandService;
import backend.myevent.MyEvent.news.infraestructure.persistence.jpa.UserSourceRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserSourceRepository userSourceRepository;

    public UserCommandServiceImpl(UserSourceRepository userSourceRepository) {
        this.userSourceRepository = userSourceRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        if (userSourceRepository.existsByNameAndSurname(command.correo(), command.surname())) {
            throw new IllegalArgumentException("User with same name and surname already exists");
        }
        var user = new User(command);
        var createdUser = userSourceRepository.save(user);
        return Optional.of(createdUser);
    }

}
