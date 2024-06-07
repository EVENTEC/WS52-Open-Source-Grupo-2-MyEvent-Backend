package backend.myevent.MyEvent.news.infraestructure.persistence.jpa;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventSourceRepository extends JpaRepository<Event, Long>{
    List<Event> findAllByEventApiKey(String eventApiKey);
    boolean existsByNameAndOrganizer(String name, String organizer);
    Optional<Event> findByNameAndOrganizer(String name, String organizer);
    Optional<Event> findByName(String name);

}
