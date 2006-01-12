/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.helpers;

public class FlagBitmap {
  public static boolean flagSet(String flags) {
    for (int n = 0; n < flags.length(); n++) {
      if (flags.charAt(n) == 'Y') {
        return true;
      }
    }
    return false;
  }
}
