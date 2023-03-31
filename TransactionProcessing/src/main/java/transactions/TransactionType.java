package transactions;

public enum TransactionType {

    BUY("B"),
    SELL("S");

    private final String shortName;

    TransactionType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return this.name();
    }
}
