package leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author fzhang
 * @date 2021-04-29
 */
public class Solution8 {

    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * @param s 输入字符串
     * @return 返回有符号整数
     */
    public int myAtoi(String s) {
        StringBuilder builder = new StringBuilder();
        String trim = s.trim();

        int flag = 1;

        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (i == 0) {
                    if (charAt == '-' || charAt == '+') {
                        builder.append(charAt);
                        if (charAt == '-') {
                            flag = -1;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    break;
                }
            } else {
                builder.append(charAt);
            }
        }

        if (builder.length() == 0) {
            return 0;
        } else if (builder.length() == 1) {
            if (builder.charAt(0) == '-' || builder.charAt(0) == '+') {
                return 0;
            }
        }

        int integer = 0;

        try {
            integer = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            if (flag == 1) {
                integer = Integer.MAX_VALUE;
            } else {
                integer = Integer.MIN_VALUE;
            }
        }

        return integer;
    }
}
