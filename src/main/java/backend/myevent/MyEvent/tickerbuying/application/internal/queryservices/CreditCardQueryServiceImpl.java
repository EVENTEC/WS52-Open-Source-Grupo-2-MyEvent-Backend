package backend.myevent.MyEvent.tickerbuying.application.internal.queryservices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetAllCreditCardsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.CreditCardQueries.GetCreditCardByIdQuery;
import backend.myevent.MyEvent.tickerbuying.domain.services.CreditCardServices.CreditCardQueryService;
import backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardQueryServiceImpl implements CreditCardQueryService {
    private final CreditCardRepository creditCardRepository;
    public CreditCardQueryServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Optional<CreditCard> handle(GetCreditCardByIdQuery query) {
        return creditCardRepository.findById(query.id());
    }
    @Override
    public List<CreditCard> handle(GetAllCreditCardsQuery query) {
        return creditCardRepository.findAll();
    }
}
