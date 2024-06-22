package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.creditcardtransform;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.CreditCardCommands.CreateCreditCardCommand;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.creditcardresources.CreateCreditCardResource;

public class CreateCreditCardCommandFromResourceAssembler {
    public static CreateCreditCardCommand toCommandFromResource(CreateCreditCardResource createCreditCardResource) {
        return new CreateCreditCardCommand(
                createCreditCardResource.owner(),
                createCreditCardResource.number(),
                createCreditCardResource.expiration(),
                createCreditCardResource.cvv(),
                createCreditCardResource.funds()
        );
    }
}
