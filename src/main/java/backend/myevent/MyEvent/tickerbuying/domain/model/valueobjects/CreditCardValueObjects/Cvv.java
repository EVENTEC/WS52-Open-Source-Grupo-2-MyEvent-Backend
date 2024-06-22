package backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects;

public record Cvv(String cvvNumber) {
    public Cvv {
        if (cvvNumber == null || cvvNumber.isBlank()) {
            throw new IllegalArgumentException("CVV number must not be null and must be a 3-digit number");
        }
    }

    public String getCvvNumber() {
        return cvvNumber;
    }
}
