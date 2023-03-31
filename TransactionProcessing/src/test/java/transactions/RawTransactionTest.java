package transactions;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RawTransactionTest {

    @Test
    public void verify_getters() {
        BigDecimal contracts = BigDecimal.valueOf(100);
        RawTransaction rawTransaction = new RawTransaction(5, 2, contracts, "AAA", TransactionType.SELL);

        assertEquals(5, rawTransaction.getSecurityId());
        assertEquals(2, rawTransaction.getPortfolioId());
        assertEquals(contracts, rawTransaction.getNominal());
        assertEquals("AAA", rawTransaction.getOms());
        assertEquals(TransactionType.SELL, rawTransaction.getTransactionType());
    }
}