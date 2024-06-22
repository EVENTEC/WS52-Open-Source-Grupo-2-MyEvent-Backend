package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.ShippingDetails;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.ShippingDetails;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.ShippingDetailsResource;
import backend.myevent.MyEvent.tickerbuying.shared.exceptionhandler.NullHandler;

public class ShippingDetailsResourceFromEntityAssembler {
    public static ShippingDetailsResource toResourceFromEntity(ShippingDetails shippingDetails) {
        if (shippingDetails == null) {
            return new ShippingDetailsResource("null", "null", "null", "null", "null", "null", "null", "null");
        }
        return new ShippingDetailsResource(
                NullHandler.handleNullString(shippingDetails.getFirstName()),
                NullHandler.handleNullString(shippingDetails.getLastName()),
                NullHandler.handleNullString(shippingDetails.getCompany()),
                NullHandler.handleNullString(shippingDetails.getAddress1()),
                NullHandler.handleNullString(shippingDetails.getAddress2()),
                NullHandler.handleNullString(shippingDetails.getCity()),
                NullHandler.handleNullString(shippingDetails.getState()),
                NullHandler.handleNullString(shippingDetails.getPostcode())
        );
    }
}