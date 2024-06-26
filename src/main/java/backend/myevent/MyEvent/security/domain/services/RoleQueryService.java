package backend.myevent.MyEvent.security.domain.services;

import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.domain.models.queries.GetAllRolesQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
