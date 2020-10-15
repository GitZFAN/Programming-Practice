package leetcode;

/**
 * 1143. 最长公共子序列
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * @author fzhang
 * @date 2020-10-15
 * @see Solution72 72. 编辑距离(相同思路)
 */
public class Solution1143 {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * <p>
     * 若这两个字符串没有公共子序列，则返回 0。
     * <p>
     * 思路：动态规划 类似{@link Solution72#minDistance(String, String)}
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] ints = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    ints[i][j] = 1 + ints[i - 1][j - 1];
                } else {
                    ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
                }
            }
        }
        return ints[length1][length2];
    }

    /**
     * <p>
     * 考虑递归方法
     * <p>
     * 结果：
     * 超出时间限制	N/A	N/A
     * <p>
     * 原因：
     * 递归过程中存在大量重复子问题
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        return dp(chars1, chars1.length - 1, chars2, chars2.length - 1);
    }

    private int dp(char[] chars1, int index1, char[] chars2, int index2) {
        if (index1 == -1 || index2 == -1) {
            return 0;
        }
        if (chars1[index1] == chars2[index2]) {
            // 找到一个 lcs 中的字符
            return 1 + dp(chars1, index1 - 1, chars2, index2 - 1);
        } else {
            return Math.max(
                    // 删除 chars1[index1]
                    dp(chars1, index1 - 1, chars2, index2),
                    // 删除 chars2[index2]
                    dp(chars1, index1, chars2, index2 - 1));
        }
    }
}
