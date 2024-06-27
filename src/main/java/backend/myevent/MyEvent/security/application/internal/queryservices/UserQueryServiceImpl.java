package backend.myevent.MyEvent.security.application.internal.queryservices;

import backend.myevent.MyEvent.security.domain.models.aggregates.User;
import backend.myevent.MyEvent.security.domain.models.queries.GetAllUsersQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByEmailQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByIdQuery;
import backend.myevent.MyEvent.security.domain.services.UserQueryService;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.Id());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByName(query.correo());

    }
}
