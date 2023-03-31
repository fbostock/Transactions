package transactions.filereaders;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioReader extends DataReader {

    public PortfolioReader(File file) throws IOException {
        super(file);
    }

    public Map<Integer, String> getPortfolios() {
        Map<Integer, String> portfolios = new HashMap<>();
        for (List<String> datum : data) {
            String portfolio = datum.get(headerMap.get("PortfolioCode"));
            portfolios.put(Integer.parseInt(datum.get(headerMap.get("PortfolioId"))), portfolio);
        }
        return portfolios;
    }
}