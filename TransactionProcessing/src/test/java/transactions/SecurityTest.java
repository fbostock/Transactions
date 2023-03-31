package transactions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SecurityTest {

    @Test
    public void verify_equality() {
        Security security = new Security("Isin1", "Cusip1", "Ticker1");
        assertEquals(security, new Security("Isin1", "Cusip1", "Ticker1"));
        assertNotEquals("Should differ by Isin", security, new Security("Isin2", "Cusip1", "Ticker1"));
        assertNotEquals("Should differ by Cusip", security, new Security("Isin1", "Cusip2", "Ticker1"));
        assertNotEquals("Should differ by Ticker", security, new Security("Isin1", "Cusip1", "Ticker2"));
    }
}