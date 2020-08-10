package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原IP地址
 *
 * @author fzhang
 * @date 2020-08-09
 */
public class Solution93 {
    public static final int MIN = 0;
    public static final int MAX = 255;

    public List<String> restoreIpAddresses(String s) {
        return getIpAddress(s, 4);
    }

    private List<String> getIpAddress(String s, int digits) {
        LinkedList<String> linkedList = new LinkedList<>();
        if (digits == 1) {
            if (s != null && s.length() < 4) {
                if (s.length() > 1 && s.startsWith("0")) {
                    return linkedList;
                }
                int integer = Integer.parseInt(s);
                if (MAX >= integer && integer >= MIN) {
                    linkedList.add(s);
                    return linkedList;
                }
            }
            return linkedList;
        }

        for (int i = 1; i < 4; i++) {
            if (s.length() > i) {
                String substring = s.substring(0, i);
                if (substring.length() > 1 && substring.startsWith("0")) {
                    continue;
                }
                int integer = Integer.parseInt(substring);
                if (MAX >= integer && integer >= MIN) {
                    List<String> ipAddress = getIpAddress(s.substring(i), digits - 1);
                    if (ipAddress.size() != 0) {
                        for (String address : ipAddress) {
                            linkedList.add(substring + "." + address);
                        }
                    }
                }
            }
        }

        return linkedList;
    }
}
