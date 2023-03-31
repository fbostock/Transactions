package transactions;

import org.junit.Test;
import transactions.referencedata.PortfolioProviderMap;

import java.util.Map;

import static org.junit.Assert.*;

public class PortfolioProviderMapTest {

    @Test
    public void validate_portfolio_retrieval() {
        String portfolio1 = "Portfolio1";
        String portfolio2 = "Portfolio2";
        PortfolioProviderMap provider = new PortfolioProviderMap(Map.of(1, portfolio1, 2, portfolio2));

        assertNull("Invalid portfolioId should return null", provider.getPortfolio(0));
        assertEquals(portfolio1, provider.getPortfolio(1));
        assertEquals(portfolio2, provider.getPortfolio(2));
    }
}