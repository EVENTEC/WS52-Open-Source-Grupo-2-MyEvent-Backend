package backend.myevent.MyEvent.security.infrastructure.hashing.bcrypt;

import backend.myevent.MyEvent.security.application.internal.outhboundedservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
