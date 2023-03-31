package transactions.referencedata;

import transactions.Security;

import java.util.Map;

public class SecurityProviderMap implements SecurityProvider {
    private final Map<Integer, Security> securities;

    public SecurityProviderMap(Map<Integer, Security> securities) {
        this.securities = securities;
    }

    public Security getSecurity(int securityId) {
        return securities.get(securityId);
    }
}
