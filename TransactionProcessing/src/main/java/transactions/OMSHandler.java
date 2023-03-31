package transactions;

import transactions.omswriters.OMSFileWriter;

import java.io.IOException;

public class OMSHandler {

    private final OMSFileWriter writer;

    public OMSHandler(OMSFileWriter writer) {
        this.writer = writer;
    }

    public void sendTransaction(DecoratedTransaction decoratedTransaction) throws IOException {
        writer.write(decoratedTransaction);
    }
}
