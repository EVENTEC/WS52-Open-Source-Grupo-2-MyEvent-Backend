package backend.myevent.MyEvent.security.application.internal.queryservices;

import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.domain.models.queries.GetAllRolesQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetRoleByNameQuery;
import backend.myevent.MyEvent.security.domain.services.RoleQueryService;
import backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
