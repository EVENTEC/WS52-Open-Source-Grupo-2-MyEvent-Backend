package backend.myevent.MyEvent.security.interfaces.rest.transform;

import backend.myevent.MyEvent.security.domain.models.commands.SignInCommand;
import backend.myevent.MyEvent.security.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.correo(), signInResource.password());
    }
}
