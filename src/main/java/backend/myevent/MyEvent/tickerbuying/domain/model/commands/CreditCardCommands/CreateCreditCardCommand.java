package backend.myevent.MyEvent.tickerbuying.domain.model.commands.CreditCardCommands;

public record CreateCreditCardCommand(
        String owner,
        String cardNumber,
        String expiration,
        String cvv,
        String funds
){

}
