package transactions;

import java.math.BigDecimal;

public class DecoratedTransaction {

    private final RawTransaction transaction;
    private final Security security;
    private final String portfolio;


    public DecoratedTransaction(RawTransaction transaction, Security security, String portfolio) {
        this.transaction = transaction;
        this.security = security;
        this.portfolio = portfolio;
    }

    public String getIsin() {
        return security.getIsin();
    }

    public String getTicker() {
        return security.getTicker();
    }

    public String getCusip() {
        return security.getCusip();
    }

    public BigDecimal getNominal() {
        return transaction.getNominal();
    }

    public TransactionType getTransactionType() {
        return transaction.getTransactionType();
    }

    public String getPortfolio() {
        return portfolio;
    }
}
