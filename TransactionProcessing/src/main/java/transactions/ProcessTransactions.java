package transactions;

import transactions.filereaders.PortfolioReader;
import transactions.filereaders.SecurityReader;
import transactions.filereaders.TransactionReader;
import transactions.omswriters.OMSFileWriterAAA;
import transactions.omswriters.OMSFileWriterBBB;
import transactions.omswriters.OMSFileWriterCCC;
import transactions.referencedata.PortfolioProvider;
import transactions.referencedata.PortfolioProviderMap;
import transactions.referencedata.SecurityProvider;
import transactions.referencedata.SecurityProviderMap;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProcessTransactions {

    public static void main(String[] args) {

        try {
            File securityFile = new File(Objects.requireNonNull(ProcessTransactions.class.getResource("/securities.csv")).toURI());
            File portfoliosFile = new File(Objects.requireNonNull(ProcessTransactions.class.getResource("/portfolios.csv")).toURI());
            File transactionsFile = new File(Objects.requireNonNull(ProcessTransactions.class.getResource("/transactions.csv")).toURI());

            SecurityProvider securityProvider = getSecurityProvider(securityFile);
            PortfolioProvider portfolioProvider = getPortfolioProvider(portfoliosFile);

            //create handlers for the different OMS systems,
            Map<String, OMSHandler> handlers = new HashMap<>();
            //set output to classes directory in IDE. Change to send to alternative destination.

            File targetOutputPath = transactionsFile.getParentFile();
            handlers.put("AAA", new OMSHandler(new OMSFileWriterAAA(targetOutputPath)));
            handlers.put("BBB", new OMSHandler(new OMSFileWriterBBB(targetOutputPath)));
            handlers.put("CCC", new OMSHandler(new OMSFileWriterCCC(targetOutputPath)));

            //Create the transaction processor which will delegate the transactions to the appropriate OMS, depending on the
            //OMS specified in the transaction
            TransactionProcessor transactionProcessor = new TransactionProcessor(securityProvider, portfolioProvider, handlers);

            //iterate over the transactions file, and process each transaction in turn:
            TransactionReader transactionReader = new TransactionReader(transactionsFile);
            for (int i = 0; i < transactionReader.getSize(); i++) {
                transactionProcessor.process(transactionReader.getTransaction(i));
            }

        } catch (URISyntaxException e) {
            System.out.println("Failed to open file: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to read/write file: " + e);
            e.printStackTrace();
        }

    }

    private static SecurityProvider getSecurityProvider(File securityFile) throws IOException {
        SecurityReader securityReader = new SecurityReader(securityFile);
        return new SecurityProviderMap(securityReader.getSecurities());
    }

    private static PortfolioProvider getPortfolioProvider(File portfolioFile) throws IOException {
        PortfolioReader portfolioReader = new PortfolioReader(portfolioFile);
        return new PortfolioProviderMap(portfolioReader.getPortfolios());
    }
}
