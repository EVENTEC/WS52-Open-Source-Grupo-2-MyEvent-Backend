package backend.myevent.MyEvent.security.domain.services;

import backend.myevent.MyEvent.news.domain.model.aggregates.User;
import backend.myevent.MyEvent.security.domain.models.queries.GetAllUsersQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByEmailQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
