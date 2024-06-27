package backend.myevent.MyEvent.security.interfaces.rest.transform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backend.myevent.MyEvent.security.domain.models.commands.SignUpCommand;
import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    private static final Logger logger = LoggerFactory.getLogger(SignUpCommandFromResourceAssembler.class);

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        logger.info("Transforming SignUpResource to SignUpCommand");
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        logger.info("Roles transformed: {}", roles);
        SignUpCommand command = new SignUpCommand(
                resource.name(),
                resource.surname(),
                resource.correo(),
                resource.password(),
                resource.phone(),
                resource.dni(),
                resource.tipoDeCuenta(),
                resource.premium(),
                roles
        );
        logger.info("SignUpCommand created: {}", command);
        return command;
    }
}