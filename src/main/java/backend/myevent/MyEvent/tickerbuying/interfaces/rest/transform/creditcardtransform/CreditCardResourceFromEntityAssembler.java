package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.creditcardtransform;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.CreditCard;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.creditcardresources.CreditCardResource;

public class CreditCardResourceFromEntityAssembler {
    public static CreditCardResource toResourceFromEntity(CreditCard creditCard) {
        return new CreditCardResource(
                creditCard.getId(),
                creditCard.getOwner(),
                creditCard.getNumber(),
                creditCard.getExpiration(),
                creditCard.getCvv(),
                creditCard.getFunds()
        );
    }
}
