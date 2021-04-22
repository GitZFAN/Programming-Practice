package leetcode;

/**
 * 6. Z 字形变换
 *
 * @author fzhang
 * @date 2021-04-22
 */
public class Solution6 {
    /**
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param s       输入字符串
     * @param numRows 给定行数
     * @return 输出从左往右逐行读取，产生出的新字符串
     */
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        if (numRows == 1) {
            return s;
        }

        int sign = -1;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == 0 || j == numRows - 1) {
                sign *= -1;
            }

            builders[j].append(s.charAt(i));

            j += sign;
        }

        StringBuilder builder = new StringBuilder();

        for (StringBuilder stringBuilder : builders) {
            builder.append(stringBuilder);
        }
        return builder.toString();
    }
}
