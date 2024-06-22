package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.Bill;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillItems.BillItemResourceFromEntityAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillingDetails.BillingDetailsResourceFromEntityAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.ShippingDetails.ShippingDetailsResourceFromEntityAssembler;
import backend.myevent.MyEvent.tickerbuying.shared.exceptionhandler.NullHandler;

import java.util.stream.Collectors;

public class BillResourceFromEntityAssembler {
    public static BillResource toResourceFromEntity(Bill bill) {

        var billingDetailsResource = BillingDetailsResourceFromEntityAssembler.toResourceFromEntity(bill.getBillingDetails());
        var shippingDetailsResource = ShippingDetailsResourceFromEntityAssembler.toResourceFromEntity(bill.getShippingDetails());
        var billItemResources = bill.getBillItems().stream()
                .map(BillItemResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return new BillResource(
                bill.getId(),
                billingDetailsResource,
                shippingDetailsResource,
                billItemResources,
                bill.getTotalAmount()
        );
    }
}