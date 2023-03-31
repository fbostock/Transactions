package transactions;

import org.junit.Test;
import transactions.referencedata.SecurityProviderMap;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class SecurityProviderMapTest {

    @Test
    public void validate_retrieval_from_security_provider() {

        Security security1 = new Security("Isin1", "Cusip1", "Ticker1");
        Security security2 = new Security("Isin2", "Cusip2", "Ticker2");
        Map<Integer, Security> map = Map.of(1, security1, 2, security2);
        SecurityProviderMap securityProvider = new SecurityProviderMap(map);

        assertNull("Invalid securityID should return null", securityProvider.getSecurity(0));
        assertEquals(security1, securityProvider.getSecurity(1));
        assertEquals(security2, securityProvider.getSecurity(2));
    }
}