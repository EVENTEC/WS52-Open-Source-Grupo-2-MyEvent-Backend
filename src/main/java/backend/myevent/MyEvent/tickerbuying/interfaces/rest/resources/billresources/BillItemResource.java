package backend.myevent.MyEvent.tickerbuying.interfaces.rest.resources.billresources;

public record BillItemResource(
        Long productId,
        String productName,
        Integer quantity,
        Double price
) {
}
