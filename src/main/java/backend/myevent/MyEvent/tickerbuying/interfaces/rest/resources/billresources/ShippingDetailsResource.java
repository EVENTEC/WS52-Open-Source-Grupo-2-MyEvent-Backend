package backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources;

public record ShippingDetailsResource(
        String firstName,
        String lastName,
        String company,
        String address1,
        String address2,
        String city,
        String state,
        String postcode
) {
}
