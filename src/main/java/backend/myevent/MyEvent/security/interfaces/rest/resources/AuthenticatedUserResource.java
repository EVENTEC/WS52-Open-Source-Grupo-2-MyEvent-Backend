package backend.myevent.MyEvent.security.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String correo, String token) {
}
