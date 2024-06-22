package backend.myevent.MyEvent.tickerbuying.application.internal.commandservices;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.CreateBillCommand;
import backend.myevent.MyEvent.tickerbuying.domain.services.BillServices.BillCommandService;
import backend.myevent.MyEvent.tickerbuying.infrastructure.persistance.jpa.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillCommandServiceImpl implements BillCommandService {

    private final BillRepository billRepository;

    public BillCommandServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Optional<Bill> handle(CreateBillCommand command) {
        var bill = new Bill(command);
        billRepository.save(bill);
        return Optional.of(bill);
    }


}
