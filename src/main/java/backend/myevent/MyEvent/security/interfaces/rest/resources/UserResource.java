package backend.myevent.MyEvent.security.interfaces.rest.resources;

import backend.myevent.MyEvent.security.domain.models.entities.Role;

import java.util.List;

public record UserResource(
        Long Id,
        String name,
        String surname,
        String correo,
        String phone,
        String dni,
        String tipoDeCuenta,
        String premium,
        List<String> roles

) {
}
