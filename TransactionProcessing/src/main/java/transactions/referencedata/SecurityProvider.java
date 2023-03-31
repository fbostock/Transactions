package transactions.referencedata;

import transactions.Security;

public interface SecurityProvider {

    Security getSecurity(int securityId);
}
