package leetcode;

/**
 * 72. 编辑距离
 *
 * @author fzhang
 * @date 2020-10-14
 */
public class Solution72 {
    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * 思路：动态规划
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 将 word1 转换成 word2 （反义亦然）所使用的最少操作数
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] ints = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            ints[i][0] = 0;
        }
        for (int i = 0; i <= length2; i++) {
            ints[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // skip
                    ints[i][j] = ints[i - 1][j - 1];
                } else {
                    int minEditDis = Math.min(
                            // delete
                            ints[i - 1][j],
                            // insert
                            ints[i][j - 1]);
                    minEditDis = Math.min(minEditDis,
                            // replace
                            ints[i - 1][j - 1]);
                    ints[i][j] = 1 + minEditDis;
                }
            }
        }

        return ints[length1][length2];
    }

    /**
     * 思路：
     * 解决两个字符串的动态规划问题，一般都是用两个指针 i,j 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模。
     * <p>
     * 结果：
     * 超出时间限制	N/A	N/A
     * <p>
     * 原因：
     * 递归过程中存在大量重复子问题
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 将 word1 转换成 word2 （反义亦然）所使用的最少操作数
     */
    public int minDistance1(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        return minEditDis(chars1, chars1.length - 1, chars2, chars2.length - 1);
    }

    private int minEditDis(char[] chars1, int index1, char[] chars2, int index2) {
        if (index1 == -1) {
            return index2 + 1;
        }
        if (index2 == -1) {
            return index1 + 1;
        }

        if (chars1[index1] == chars2[index2]) {
            // skip
            return minEditDis(chars1, index1 - 1, chars2, index2 - 1);
        } else {
            int minDis = Math.min(
                    // insert
                    minEditDis(chars1, index1, chars2, index2 - 1),
                    // delete
                    minEditDis(chars1, index1 - 1, chars2, index2));
            minDis = Math.min(minDis,
                    // replace
                    minEditDis(chars1, index1 - 1, chars2, index2 - 1));
            return minDis + 1;
        }
    }
}
