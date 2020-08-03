package leetcode;

import java.util.Arrays;

/**
 * 415. 字符串相加
 *
 * @author fzhang
 * @date 03/08/2020
 */
public class Solution415 {
    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        String addStrings = solution415.addStrings("408", "5");
        System.out.println("addStrings = " + addStrings);
    }

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int length = Math.max(num1.length(), num2.length());

        char[] result = new char[length + 1];
        Arrays.fill(result, '0');

        int flag = 0;

        char[] large;
        char[] small;
        if (chars1.length > chars2.length) {
            large = chars1;
            small = chars2;
        } else {
            large = chars2;
            small = chars1;
        }

        for (int i = 0; i < small.length; i++) {
            char c1 = large[large.length - 1 - i];
            char c2 = small[small.length - 1 - i];
            int v = c1 - '0' + c2 - '0';
            v += flag;
            if (v > 9) {
                flag = 1;
                v -= 10;
            } else {
                flag = 0;
            }
            char nc = (char) (v + '0');
            result[result.length - 1 - i] = nc;
        }
        for (int i = small.length; i < large.length; i++) {
            char c = large[large.length - 1 - i];
            int v = c - '0';
            v += flag;
            if (v > 9) {
                flag = 1;
                v -= 10;
            } else {
                flag = 0;
            }
            char nc = (char) (v + '0');
            result[result.length - 1 - i] = nc;
        }
        if (flag != 0) {
            result[result.length - 1 - large.length] = '1';
            return String.valueOf(result);
        } else {
            StringBuilder builder = new StringBuilder(result.length - 1);
            for (int i = 1; i < result.length; i++) {
                builder.append(result[i]);
            }
            return builder.toString();
        }
    }
}
