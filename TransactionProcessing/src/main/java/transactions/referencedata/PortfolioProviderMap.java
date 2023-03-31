package transactions.referencedata;

import java.util.Map;

public class PortfolioProviderMap implements PortfolioProvider {

    private final Map<Integer, String> portfolios;

    public PortfolioProviderMap(Map<Integer, String> portfolios) {
        this.portfolios = portfolios;
    }

    @Override
    public String getPortfolio(int portfolioId) {
        return portfolios.get(portfolioId);
    }
}
