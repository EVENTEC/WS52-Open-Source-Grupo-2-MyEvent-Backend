package backend.myevent.MyEvent.tickerbuying.interfaces.rest.transform.billtransform.BillItems;

import backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands.BillItemCommand;
import backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources.BillItemResource;

public class BillItemCommandFromResourceAssembler {
    public static BillItemCommand toCommandFromResource(BillItemResource resource) {
        return new BillItemCommand(
                resource.productId(),
                resource.productName(),
                resource.quantity(),
                resource.price()
        );
    }
}