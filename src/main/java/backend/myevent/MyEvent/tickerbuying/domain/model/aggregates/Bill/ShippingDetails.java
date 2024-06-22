package backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.ShippingDetailsCommand;
import backend.myevent.MyEvent.tickerbuying.shared.exceptionhandler.NullHandler;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShippingDetails {
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;

    public ShippingDetails() {
    }

    public ShippingDetails(ShippingDetailsCommand command) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.company = command.company();
        this.address1 = command.address1();
        this.address2 = command.address2();
        this.city = command.city();
        this.state = command.state();
        this.postcode = command.postcode();
    }
    public String getFirstName() {
        return NullHandler.handleNullString(firstName);
    }

    public String getLastName() {
        return NullHandler.handleNullString(lastName);
    }

    public String getCompany() {
        return NullHandler.handleNullString(company);
    }

    public String getAddress1() {
        return NullHandler.handleNullString(address1);
    }

    public String getAddress2() {
        return NullHandler.handleNullString(address2);
    }

    public String getCity() {
        return NullHandler.handleNullString(city);
    }

    public String getState() {
        return NullHandler.handleNullString(state);
    }

    public String getPostcode() {
        return NullHandler.handleNullString(postcode);
    }
}
