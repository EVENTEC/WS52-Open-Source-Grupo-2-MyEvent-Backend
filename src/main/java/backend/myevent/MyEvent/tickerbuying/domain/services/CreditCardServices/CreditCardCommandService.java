package backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.domain.model.commands.CreditCardCommands.CreateCreditCardCommand;

import java.util.Optional;

public interface CreditCardCommandService {
    Optional<CreditCard> handle(CreateCreditCardCommand command);
}
