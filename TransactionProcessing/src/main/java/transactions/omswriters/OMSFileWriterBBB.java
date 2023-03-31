package transactions.omswriters;

import transactions.DecoratedTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OMSFileWriterBBB extends OMSFileWriter {

    public OMSFileWriterBBB(File path) throws IOException {
        super(new File(path, "output.bbb"), "|");
        writeHeaders(List.of("Cusip", "PortfolioCode", "Nominal", "TransactionType"));
    }

    public void write(DecoratedTransaction transaction) throws IOException {
        write(List.of(transaction.getCusip(), transaction.getPortfolio(), transaction.getNominal(),
                transaction.getTransactionType().getName()));
    }
}
