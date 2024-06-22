package backend.myevent.MyEvent.tickerbuying.domain.services.BillServices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.CreateBillCommand;

import java.util.Optional;

public interface BillCommandService {
    Optional<Bill> handle(CreateBillCommand command);
}
