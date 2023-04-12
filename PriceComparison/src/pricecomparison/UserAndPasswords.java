package pricecomparison;

import java.util.HashMap;

/**
 * UserAndPasswords --- HashMap that contains users and passwords.
 *
 * @author
 */
public class UserAndPasswords {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    UserAndPasswords() {
        loginInfo.put("user", "password");
        loginInfo.put("guy", "ilovesaving");
    }

    /**
     * returns loginInfo
     *
     * @return loginInfo.
     */
    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
