package backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects;

public record CardNumber(String cardNumber) {
    public CardNumber {
        if (cardNumber == null || cardNumber.isBlank()) {
            throw new IllegalArgumentException("Card number must not be null or blank");
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
