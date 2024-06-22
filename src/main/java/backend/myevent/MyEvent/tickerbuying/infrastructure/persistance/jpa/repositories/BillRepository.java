package backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findById(Long id);
}
