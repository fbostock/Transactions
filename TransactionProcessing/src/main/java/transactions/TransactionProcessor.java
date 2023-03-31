package transactions;

import transactions.referencedata.PortfolioProvider;
import transactions.referencedata.SecurityProvider;

import java.io.IOException;
import java.util.Map;

public class TransactionProcessor {

    private final SecurityProvider securityProvider;
    private final PortfolioProvider portfolioProvider;
    private final Map<String, OMSHandler> omsHandlers;

    public TransactionProcessor(SecurityProvider securityProvider, PortfolioProvider portfolioProvider, Map<String, OMSHandler> omsHandlers) {
        this.securityProvider = securityProvider;
        this.portfolioProvider = portfolioProvider;
        this.omsHandlers = omsHandlers;
    }

    public void process(RawTransaction rawTransaction) throws IOException {
        OMSHandler omsHandler = omsHandlers.get(rawTransaction.getOms());
        Security security = securityProvider.getSecurity(rawTransaction.getSecurityId());
        String portfolio = portfolioProvider.getPortfolio(rawTransaction.getPortfolioId());
        omsHandler.sendTransaction(new DecoratedTransaction(rawTransaction, security, portfolio));
    }

}
