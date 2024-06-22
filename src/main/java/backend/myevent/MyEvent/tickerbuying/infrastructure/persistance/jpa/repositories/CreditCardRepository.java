package backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.CardNumber;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Cvv;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Expiration;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{
    Optional<CreditCard> findByOwnerAndCardNumberAndExpirationAndCvv(Owner owner, CardNumber cardNumber, Expiration expiration, Cvv cvv);
    Optional<CreditCard> findById(Long Id);

}
