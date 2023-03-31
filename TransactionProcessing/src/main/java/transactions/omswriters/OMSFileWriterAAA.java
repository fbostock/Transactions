package transactions.omswriters;

import transactions.DecoratedTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OMSFileWriterAAA extends OMSFileWriter {

    public OMSFileWriterAAA(File path) throws IOException {
        super(new File(path, "output.aaa"), ",");
        writeHeaders(List.of("ISIN", "PortfolioCode", "Nominal", "TransactionType"));
    }

    public void write(DecoratedTransaction transaction) throws IOException {
        write(List.of(transaction.getIsin(), transaction.getPortfolio(), transaction.getNominal(),
                transaction.getTransactionType().getName()));
    }


}
