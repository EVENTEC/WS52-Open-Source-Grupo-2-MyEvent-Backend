package backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands;

import java.util.List;

public record CreateBillCommand(
        BillingDetailsCommand billingDetails,
        ShippingDetailsCommand shippingDetails,
        List<BillItemCommand> billItems,
        Double totalAmount
) {
}

