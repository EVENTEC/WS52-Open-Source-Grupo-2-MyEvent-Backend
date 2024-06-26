package backend.myevent.MyEvent.security.infrastructure.persistence.jpa.repositories;


import backend.myevent.MyEvent.news.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCorreo(String username);
    Optional<User> findByName(String username);
    boolean existsByCorreo(String username);

}
