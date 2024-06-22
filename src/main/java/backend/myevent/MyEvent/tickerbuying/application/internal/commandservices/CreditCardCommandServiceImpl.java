package backend.myevent.MyEvent.tickerbuying.application.internal.commandservices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.domain.model.commands.CreditCardCommands.CreateCreditCardCommand;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.CardNumber;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Cvv;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Expiration;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.Owner;
import backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices.CreditCardCommandService;
import backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardCommandServiceImpl implements CreditCardCommandService {
    private final CreditCardRepository creditCardRepository;

    public CreditCardCommandServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Optional<CreditCard> handle(CreateCreditCardCommand command) {
        var CardOwner = new Owner(command.owner());
        var CardNumber = new CardNumber(command.cardNumber());
        var CardExpiration = new Expiration(command.expiration());
        var CardCvv = new Cvv(command.cvv());

        creditCardRepository.findByOwnerAndCardNumberAndExpirationAndCvv(CardOwner, CardNumber, CardExpiration, CardCvv)
                .ifPresent(card -> {
                    throw new IllegalArgumentException("Credit card already exists");
                });
        var CreditCard = new CreditCard(command);
        creditCardRepository.save(CreditCard);
        return Optional.of(CreditCard);
    }
}
