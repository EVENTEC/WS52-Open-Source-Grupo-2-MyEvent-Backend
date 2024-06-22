package backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects;

public record Owner(String name) {
    public Owner {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Owner name must not be null or blank");
        }
    }

    public String getOwnerName() {
        return name;
    }
}
