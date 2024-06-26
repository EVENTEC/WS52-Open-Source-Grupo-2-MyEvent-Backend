package backend.myevent.MyEvent.security.infrastructure.authorization.sfs.model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class EmailPasswordAuthenticationTokenBuilder {

    public static EmailPasswordAuthenticationToken build(UserDetails principal, HttpServletRequest request) {
        var emailPasswordAuthenticationToken = new EmailPasswordAuthenticationToken(principal, null, principal.getAuthorities());
        emailPasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return emailPasswordAuthenticationToken;
    }
}
