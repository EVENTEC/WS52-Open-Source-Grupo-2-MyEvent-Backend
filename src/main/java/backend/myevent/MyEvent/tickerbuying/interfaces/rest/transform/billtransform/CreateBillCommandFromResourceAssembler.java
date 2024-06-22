package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.CreateBillCommand;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.CreateBillResource;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillItems.BillItemCommandFromResourceAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillingDetails.BillingDetailsCommandFromResourceAssembler;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.ShippingDetails.ShippingDetailsCommandFromResourceAssembler;

import java.util.stream.Collectors;

public class CreateBillCommandFromResourceAssembler {
    public static CreateBillCommand toCommandFromResource(CreateBillResource resource) {
        var billingDetailsCommand = BillingDetailsCommandFromResourceAssembler.toCommandFromResource(resource.billingDetails());
        var shippingDetailsCommand = ShippingDetailsCommandFromResourceAssembler.toCommandFromResource(resource.shippingDetails());
        var billItemCommands = resource.orderItems().stream()
                .map(BillItemCommandFromResourceAssembler::toCommandFromResource)
                .collect(Collectors.toList());

        return new CreateBillCommand(
                billingDetailsCommand,
                shippingDetailsCommand,
                billItemCommands,
                resource.totalAmount()
        );
    }
}