package backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetAllCreditCardsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetCreditCardByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CreditCardQueryService {
    Optional<CreditCard> handle(GetCreditCardByIdQuery query);
    List<CreditCard> handle(GetAllCreditCardsQuery query);
}
