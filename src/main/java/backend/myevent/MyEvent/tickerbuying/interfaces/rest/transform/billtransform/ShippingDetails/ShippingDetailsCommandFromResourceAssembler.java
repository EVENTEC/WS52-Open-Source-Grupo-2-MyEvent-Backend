package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.ShippingDetails;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.ShippingDetailsCommand;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.ShippingDetailsResource;

public class ShippingDetailsCommandFromResourceAssembler {
    public static ShippingDetailsCommand toCommandFromResource(ShippingDetailsResource resource) {
        return new ShippingDetailsCommand(
                resource.firstName(),
                resource.lastName(),
                resource.company(),
                resource.address1(),
                resource.address2(),
                resource.city(),
                resource.state(),
                resource.postcode()
        );
    }
}