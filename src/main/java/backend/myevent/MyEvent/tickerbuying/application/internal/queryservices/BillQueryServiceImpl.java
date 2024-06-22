package backend.myevent.MyEvent.tickerbuying.application.internal.queryservices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetAllBillsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetBillByIdQuery;
import backend.myevent.MyEvent.tickerbuying.domain.services.BillServices.BillQueryService;
import backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillQueryServiceImpl implements BillQueryService {

    private final BillRepository billRepository;

    public BillQueryServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Optional<Bill> handle(GetBillByIdQuery query) {
        return billRepository.findById(query.id());
    }

    @Override
    public List<Bill> handle(GetAllBillsQuery query) {
        return billRepository.findAll();
    }

}
