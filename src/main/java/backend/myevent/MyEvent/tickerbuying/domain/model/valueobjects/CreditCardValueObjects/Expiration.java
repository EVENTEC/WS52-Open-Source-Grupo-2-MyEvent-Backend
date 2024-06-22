package backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects;

public record Expiration(String expirationDate) {
    public Expiration {
        if (expirationDate == null || expirationDate.isBlank()) {
            throw new IllegalArgumentException("Expiration date must not be null and must be in the format MM/YY");
        }
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
