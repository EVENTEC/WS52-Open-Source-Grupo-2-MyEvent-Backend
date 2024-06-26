package backend.myevent.MyEvent.security.application.internal.outhboundedservices.hashing;

public interface HashingService {
    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
