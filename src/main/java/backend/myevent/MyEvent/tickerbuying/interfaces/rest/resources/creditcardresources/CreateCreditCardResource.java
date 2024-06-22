package backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.creditcardresources;

public record CreateCreditCardResource(
        String owner,
        String number,
        String expiration,
        String cvv,
        String funds
) {
}
