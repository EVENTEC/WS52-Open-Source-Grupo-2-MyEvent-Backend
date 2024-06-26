package backend.myevent.MyEvent.security.application.internal.outhboundedservices.tokens;

public interface TokenService {
    String generateToken(String username);
    String getUsernameFromToken(String token);
    boolean validateToken(String token);

}
