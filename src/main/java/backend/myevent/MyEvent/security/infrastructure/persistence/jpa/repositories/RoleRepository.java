package backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories;

import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.domain.models.valueobjetcts.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
    boolean existsByName(Roles name);

}
