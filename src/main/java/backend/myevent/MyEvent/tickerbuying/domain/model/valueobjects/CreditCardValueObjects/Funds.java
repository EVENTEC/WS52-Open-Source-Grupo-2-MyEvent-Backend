package backend.myevent.MyEvent.tickerbuying.domain.model.valueobjects.CreditCardValueObjects;

public record Funds(String cardFunds) {
    public Funds {
        if (cardFunds == null || cardFunds.isBlank()) {
            throw new IllegalArgumentException("Card funds must not be null or blank");
        }
    }

    public String getCardFunds() {
        return cardFunds;
    }
}
