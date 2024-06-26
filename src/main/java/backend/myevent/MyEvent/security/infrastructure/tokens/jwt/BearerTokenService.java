package backend.myevent.MyEvent.security.infrastructure.tokens.jwt;

import backend.myevent.MyEvent.security.application.internal.outhboundedservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {

    String getBearerTokenFrom(HttpServletRequest token);
    String generateToken(Authentication authentication);

}
