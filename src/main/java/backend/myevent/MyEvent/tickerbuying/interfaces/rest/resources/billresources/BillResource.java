package backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.BillItem;
import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.BillingDetails;
import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.ShippingDetails;

import java.util.List;

public record BillResource(
        Long id,
        BillingDetailsResource billingDetails,
        ShippingDetailsResource shippingDetails,
        List<BillItemResource> orderItems,
        Double totalAmount
) {
}
