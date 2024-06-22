package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillItems;

import backend.myevent.MyEvent.tickerbuying.domain.model.aggregates.Bill.BillItem;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillItemResource;

public class BillItemResourceFromEntityAssembler {
    public static BillItemResource toResourceFromEntity(BillItem billItem) {
        return new BillItemResource(
                billItem.getProductId(),
                billItem.getProductName(),
                billItem.getQuantity(),
                billItem.getPrice()
        );
    }
}
