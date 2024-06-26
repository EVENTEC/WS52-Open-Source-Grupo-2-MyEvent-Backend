package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillingDetails;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.BillingDetails;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillingDetailsResource;
import backend.myevent.MyEvent.shared.exceptionhandler.NullHandler;

public class BillingDetailsResourceFromEntityAssembler {
    public static BillingDetailsResource toResourceFromEntity(BillingDetails billingDetails) {
        if (billingDetails == null) {
            return new BillingDetailsResource("null", "null", "null", "null", "null", "null", "null", "null", "null", "null");
        }
        return new BillingDetailsResource(
                NullHandler.handleNullString(billingDetails.getFirstName()),
                NullHandler.handleNullString(billingDetails.getLastName()),
                NullHandler.handleNullString(billingDetails.getCompany()),
                NullHandler.handleNullString(billingDetails.getAddress1()),
                NullHandler.handleNullString(billingDetails.getAddress2()),
                NullHandler.handleNullString(billingDetails.getCity()),
                NullHandler.handleNullString(billingDetails.getState()),
                NullHandler.handleNullString(billingDetails.getPostcode()),
                NullHandler.handleNullString(billingDetails.getEmail()),
                NullHandler.handleNullString(billingDetails.getPhone())
        );
    }
}