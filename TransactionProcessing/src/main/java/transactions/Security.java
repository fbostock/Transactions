package transactions;

import java.util.Objects;

public class Security {

    private final String isin;
    private final String cusip;
    private final String ticker;

    public Security(String isin, String cusip, String ticker) {
        this.isin = isin;
        this.cusip = cusip;
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public String getCusip() {
        return cusip;
    }

    public String getTicker() {
        return ticker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(isin, security.isin) && Objects.equals(cusip, security.cusip) && Objects.equals(ticker, security.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isin, cusip, ticker);
    }
}
