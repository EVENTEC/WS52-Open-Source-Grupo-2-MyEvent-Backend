package backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.BillItemCommand;
import backend.myevent.MyEvent.tickerbuying.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;

@Entity
public class BillItem extends AuditableAbstractAggregateRoot{
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;

    public BillItem() {
    }

    public BillItem(BillItemCommand command) {
        this.productId = command.productId();
        this.productName = command.productName();
        this.quantity = command.quantity();
        this.price = command.price();
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
