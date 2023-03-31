package transactions;

import java.math.BigDecimal;

public class RawTransaction {
    private final int securityId;
    private final int portfolioId;
    private final BigDecimal nominal;
    private final String oms;
    private final TransactionType transactionType;

    public RawTransaction(int securityId, int portfolioId, BigDecimal nominal, String OMS, TransactionType transactionType) {
        this.securityId = securityId;
        this.portfolioId = portfolioId;
        this.nominal = nominal;
        oms = OMS;
        this.transactionType = transactionType;
    }

    public int getSecurityId() {
        return securityId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public String getOms() {
        return oms;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
