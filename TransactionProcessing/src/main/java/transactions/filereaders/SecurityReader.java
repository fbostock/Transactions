package transactions.filereaders;

import transactions.Security;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityReader extends DataReader {

    public SecurityReader(File file) throws IOException {
        super(file);
    }

    public Map<Integer, Security> getSecurities() {
        Map<Integer, Security> securities = new HashMap<>();
        for (List<String> datum : data) {
            //SecurityId,ISIN,Ticker,CUSIP
            Security security = new Security(datum.get(headerMap.get("ISIN")),
                    datum.get(headerMap.get("CUSIP")),
                    datum.get(headerMap.get("Ticker")));
            securities.put(Integer.parseInt(datum.get(headerMap.get("SecurityId"))), security);
        }
        return securities;
    }
}
