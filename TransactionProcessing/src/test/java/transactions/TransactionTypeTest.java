package transactions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTypeTest {

    @Test
    public void verify_names() {
        assertEquals("BUY", TransactionType.BUY.getName());
        assertEquals("SELL", TransactionType.SELL.getName());
        assertEquals("B", TransactionType.BUY.getShortName());
        assertEquals("S", TransactionType.SELL.getShortName());
    }
}