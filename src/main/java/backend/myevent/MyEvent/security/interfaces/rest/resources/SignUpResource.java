package backend.myevent.MyEvent.security.interfaces.rest.resources;

import backend.myevent.MyEvent.security.domain.models.entities.Role;

import java.util.List;

public record SignUpResource (
        String name,
        String surname,
        String correo,
        String password,
        String phone,
        String dni,
        String tipoDeCuenta,
        String premium,
        List<String> roles
){
}
