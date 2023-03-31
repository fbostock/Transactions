package transactions.filereaders;

import transactions.RawTransaction;
import transactions.TransactionType;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TransactionReader extends DataReader {

    public TransactionReader(File file) throws IOException {
        super(file);
    }

    public RawTransaction getTransaction(int row) {
        List<String> content = data.get(row);
        return new RawTransaction(
                //SecurityId,PortfolioId,Nominal,OMS,TransactionType
                Integer.parseInt(content.get(headerMap.get("SecurityId"))),
                Integer.parseInt(content.get(headerMap.get("PortfolioId"))),
                new BigDecimal(content.get(headerMap.get("Nominal"))),
                content.get(headerMap.get("OMS")),
                TransactionType.valueOf(content.get(headerMap.get("TransactionType")))
        );
    }

}
