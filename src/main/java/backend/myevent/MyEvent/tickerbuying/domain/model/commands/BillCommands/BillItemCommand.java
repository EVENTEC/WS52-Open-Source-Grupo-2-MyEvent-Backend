package backend.myevent.MyEvent.tickerbuying.domain.model.commands.BillCommands;

public record BillItemCommand(
        Long productId,
        String productName,
        Integer quantity,
        Double price
) {
}
