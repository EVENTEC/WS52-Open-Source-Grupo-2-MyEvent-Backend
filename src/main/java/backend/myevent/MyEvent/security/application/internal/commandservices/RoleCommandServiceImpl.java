package backend.myevent.MyEvent.security.application.internal.commandservices;

import backend.myevent.MyEvent.security.domain.models.commands.SeedRoleCommand;
import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.domain.models.valueobjetcts.Roles;
import backend.myevent.MyEvent.security.domain.services.RoleCommandService;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * This method will handle the {@link SeedRoleCommand} and will create the roles if not exists
     * @param command {@link SeedRoleCommand}
     * @see SeedRoleCommand
     */
    @Override
    public void handle(SeedRoleCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        } );
    }
}
