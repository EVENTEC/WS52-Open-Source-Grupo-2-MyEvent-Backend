package backend.myevent.MyEvent.tickerbuying.domain.services.BillServices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetAllBillsQuery;
import backend.myevent.MyEvent.tickerbuying.domain.model.queries.BillQueries.GetBillByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BillQueryService {
    Optional<Bill> handle(GetBillByIdQuery query);
    List<Bill> handle(GetAllBillsQuery query);
}
