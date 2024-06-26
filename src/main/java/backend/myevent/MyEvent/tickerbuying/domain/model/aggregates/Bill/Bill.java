package backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.CreateBillCommand;
import backend.myevent.MyEvent.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Bill extends AuditableAbstractAggregateRoot {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "billing_firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "billing_lastName")),
            @AttributeOverride(name = "company", column = @Column(name = "billing_company")),
            @AttributeOverride(name = "address1", column = @Column(name = "billing_address1")),
            @AttributeOverride(name = "address2", column = @Column(name = "billing_address2")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city")),
            @AttributeOverride(name = "state", column = @Column(name = "billing_state")),
            @AttributeOverride(name = "postcode", column = @Column(name = "billing_postcode"))
    })
    @NotNull(message = "Billing details are required")
    private BillingDetails billingDetails;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "shipping_firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "shipping_lastName")),
            @AttributeOverride(name = "company", column = @Column(name = "shipping_company")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_address1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_address2")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "state", column = @Column(name = "shipping_state")),
            @AttributeOverride(name = "postcode", column = @Column(name = "shipping_postcode"))
    })
    private ShippingDetails shippingDetails;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bill_id")
    private List<BillItem> billItems;

    @NotNull(message = "Total amount is required")
    private Double totalAmount;

    public Bill(CreateBillCommand command) {
        this.billingDetails = new BillingDetails(command.billingDetails());
        this.shippingDetails = new ShippingDetails(command.shippingDetails());
        this.billItems = command.billItems().stream()
                .map(BillItem::new)
                .collect(Collectors.toList());
        this.totalAmount = command.totalAmount();
    }

    public Bill() {
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
