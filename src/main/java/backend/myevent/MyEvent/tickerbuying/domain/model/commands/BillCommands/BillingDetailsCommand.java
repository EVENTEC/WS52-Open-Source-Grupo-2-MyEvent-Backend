package backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands;

public record BillingDetailsCommand(
        String firstName,
        String lastName,
        String company,
        String address1,
        String address2,
        String city,
        String state,
        String postcode,
        String email,
        String phone
) {
}
