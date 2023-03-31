package transactions;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DecoratedTransactionTest {

    @Test
    public void verify_decoration() {

        BigDecimal contracts = BigDecimal.valueOf(100);
        RawTransaction rawTransaction = new RawTransaction(1, 5, contracts, "AAA", TransactionType.BUY);
        String portfolio = "Portfolio1";
        DecoratedTransaction decoratedTransaction = new DecoratedTransaction(rawTransaction, new Security("Isin1", "Cusip1", "Ticker1"), portfolio);

        assertEquals("Isin1", decoratedTransaction.getIsin());
        assertEquals("Cusip1", decoratedTransaction.getCusip());
        assertEquals("Ticker1", decoratedTransaction.getTicker());
        assertEquals(contracts, decoratedTransaction.getNominal());
        assertEquals(TransactionType.BUY, decoratedTransaction.getTransactionType());
        assertEquals(portfolio, decoratedTransaction.getPortfolio());
    }
}