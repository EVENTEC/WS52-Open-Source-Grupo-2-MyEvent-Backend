package backend.myevent.MyEvent.security.interfaces.rest.transform;

import backend.myevent.MyEvent.security.domain.models.aggregates.User;
import backend.myevent.MyEvent.security.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getCorreo(), token);
    }
}
