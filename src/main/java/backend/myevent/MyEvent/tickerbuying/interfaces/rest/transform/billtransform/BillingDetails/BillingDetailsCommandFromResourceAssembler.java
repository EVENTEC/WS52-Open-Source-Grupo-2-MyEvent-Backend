package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillingDetails;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.BillingDetailsCommand;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillingDetailsResource;

public class BillingDetailsCommandFromResourceAssembler {
    public static BillingDetailsCommand toCommandFromResource(BillingDetailsResource resource) {
        return new BillingDetailsCommand(
                resource.firstName(),
                resource.lastName(),
                resource.company(),
                resource.address1(),
                resource.address2(),
                resource.city(),
                resource.state(),
                resource.postcode(),
                resource.email(),
                resource.phone()
        );
    }
}