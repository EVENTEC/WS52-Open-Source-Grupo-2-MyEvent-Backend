package backend.myevent.MyEvent.security.domain.models.commands;

import backend.myevent.MyEvent.security.domain.models.entities.Role;

import java.util.List;

public record SignUpCommand(
        String name,
        String surname,
        String correo,
        String password,
        String phone,
        String dni,
        String tipoDeCuenta,
        String premium,
        List<Role> roles
) {
}
