package backend.myevent.MyEvent.security.infrastructure.authorization.sfs.services;

import backend.myevent.MyEvent.security.infrastructure.authorization.sfs.model.UserDetailsImpl;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "defaultUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method is responsible for loading the user details from the database.
     * @param correo The Email.
     * @return The UserDetails object.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        var user = userRepository.findByName(correo)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + correo));
        return UserDetailsImpl.build(user);
    }
}
