package transactions;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import transactions.referencedata.PortfolioProvider;
import transactions.referencedata.SecurityProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TransactionProcessorTest {

    @Test
    public void processor_delegates_to_correct_oms_handler() throws IOException {
        SecurityProvider securityProvider = mock(SecurityProvider.class);
        PortfolioProvider portfolioProvider = mock(PortfolioProvider.class);

        OMSHandler omsHandler = mock(OMSHandler.class);
        OMSHandler omsHandler2 = mock(OMSHandler.class);
        Map<String, OMSHandler> handlers = new HashMap<>();
        handlers.put("AAA", omsHandler);
        handlers.put("BBB", omsHandler2);


        TransactionProcessor transactionProcessor = new TransactionProcessor(securityProvider, portfolioProvider,  handlers);
        RawTransaction transaction = new RawTransaction(5, 2, BigDecimal.valueOf(1000), "AAA", TransactionType.BUY);
        transactionProcessor.process(transaction);

        verify(omsHandler, times(1)).sendTransaction(any());
        verify(omsHandler2, times(0)).sendTransaction(any());
    }

    @Test
    public void transaction_gets_decorated() throws IOException {
        SecurityProvider securityProvider = mock(SecurityProvider.class);
        PortfolioProvider portfolioProvider = mock(PortfolioProvider.class);

        when(securityProvider.getSecurity(5)).thenReturn(new Security("ISIN1", "Cusip1", "Ticker1"));
        when(portfolioProvider.getPortfolio(2)).thenReturn("Portfolio2");

        OMSHandler omsHandler = mock(OMSHandler.class);
        Map<String, OMSHandler> handlers = new HashMap<>();
        handlers.put("AAA", omsHandler);

        ArgumentCaptor<DecoratedTransaction> captor = ArgumentCaptor.forClass(DecoratedTransaction.class);

        TransactionProcessor transactionProcessor = new TransactionProcessor(securityProvider, portfolioProvider,  handlers);
        BigDecimal nominal = BigDecimal.valueOf(1000);
        RawTransaction transaction = new RawTransaction(5, 2, nominal, "AAA", TransactionType.BUY);
        transactionProcessor.process(transaction);

        verify(omsHandler, times(1)).sendTransaction(captor.capture());

        DecoratedTransaction value = captor.getValue();
        assertEquals(nominal, value.getNominal());
        assertEquals(TransactionType.BUY, value.getTransactionType());
        assertEquals("ISIN1", value.getIsin());
        assertEquals("Cusip1", value.getCusip());
        assertEquals("Ticker1", value.getTicker());
        assertEquals("Portfolio2", value.getPortfolio());
    }


}