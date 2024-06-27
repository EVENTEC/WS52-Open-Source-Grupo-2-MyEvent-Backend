package backend.myevent.MyEvent.security.interfaces.rest.transform;

import backend.myevent.MyEvent.security.domain.models.aggregates.User;
import backend.myevent.MyEvent.security.interfaces.rest.resources.UserResource;
import backend.myevent.MyEvent.security.domain.models.entities.Role;

import java.util.stream.Collectors;


public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getCorreo(),
                user.getPhone(),
                user.getDni(),
                user.getTipoDeCuenta(),
                user.getPremium(),
                roles
        );
    }
}