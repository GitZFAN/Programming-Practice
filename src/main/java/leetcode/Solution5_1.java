package leetcode;

/**
 * 解法1：动态规划
 *
 * @author TheFan
 */
public class Solution5_1 {
    public static void main(String[] args) {
        Solution5_1 solution5_1 = new Solution5_1();

        String s = "cbbd";
        System.out.println(solution5_1.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLength = 1;

        int[][] ints = new int[chars.length][chars.length];
        for (int len = 0; len < chars.length; len++) {
            for (int i = 0; i + len < chars.length; i++) {
                if (len == 0) {
                    ints[i][i] = 1;
                } else if (len == 1) {
                    if (chars[i] == chars[i + 1]) {
                        ints[i][i+1] = 1;
                        if ((len+1) > maxLength) {
                            maxLength = len + 1;
                            begin = i;
                        }
                    }
                } else {
                    if ((chars[i] == chars[i+len]) && ints[i+1][i+len-1] != 0) {
                        ints[i][i+len] = 1;
                        if ((len+1) > maxLength) {
                            maxLength = len + 1;
                            begin = i;
                        }
                    }
                }
            }
        }
        return s.substring(begin, begin+maxLength);
    }
}
