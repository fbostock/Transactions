package transactions.omswriters;

import transactions.DecoratedTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OMSFileWriterCCC extends OMSFileWriter {

    public OMSFileWriterCCC(File path) throws IOException {
        super(new File(path, "output.ccc"), ",");
        write(List.of(), false, false);
    }

    public void write(DecoratedTransaction transaction) throws IOException {
        write(List.of(transaction.getPortfolio(), transaction.getTicker(), transaction.getNominal(),
                transaction.getTransactionType().getShortName()));
    }

}