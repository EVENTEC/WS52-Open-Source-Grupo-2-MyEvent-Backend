package backend.myevent.MyEvent.tickerbuying.domain.model.aggregates;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.CreditCardCommands.CreateCreditCardCommand;
import backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects.*;
import backend.myevent.MyEvent.tickerbuying.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class CreditCard extends AuditableAbstractAggregateRoot<CreditCard> {

    @Embedded
    @NotNull(message = "Credit card owner is required")
    private Owner owner;

    @Embedded
    @NotNull(message = "Credit card number is required")
    private CardNumber cardNumber;

    @Embedded
    @NotNull(message = "Credit card expiration date is required")
    private Expiration expiration;

    @Embedded
    @NotNull(message = "Credit card CVV is required")
    private Cvv cvv;

    @Embedded
    @NotNull(message = "Credit card balance is required")
    private Funds funds;

    public CreditCard(CreateCreditCardCommand command) {
        this.owner = new Owner(command.owner());
        this.cardNumber = new CardNumber(command.cardNumber());
        this.expiration = new Expiration(command.expiration());
        this.cvv = new Cvv(command.cvv());
        this.funds = new Funds(command.funds());
    }

    public CreditCard() {
    }

    public String getOwner() {
        return owner.getOwnerName();
    }
    public String getNumber() {
        return cardNumber.getCardNumber();
    }
    public String getExpiration() {
        return expiration.getExpirationDate();
    }
    public String getCvv() {
        return cvv.getCvvNumber();
    }
    public String getFunds() {
        return funds.getCardFunds();
    }
}
