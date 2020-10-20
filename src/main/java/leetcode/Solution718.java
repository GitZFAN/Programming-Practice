package leetcode;

/**
 * 718. 最长重复子数组
 *
 * @author fzhang
 * @date 2020-10-21
 */
public class Solution718 {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * <p>
     * 思路：滑动数组
     *
     * @param A 整数数组
     * @param B 整数数组
     * @return 最长重复子数组的长度
     */
    public int findLength(int[] A, int[] B) {
        int alength = A.length;
        int blength = B.length;

        if (blength > alength) {
            // 保持 A.length() >= B.length()
            return findLength(B, A);
        }

        int offsetA = blength - 1;
        int Afrom = offsetA;
        int Aend = Afrom + alength - 1;

        int maxCommonLength = 0;
        for (int offsetB = 0; offsetB <= alength + blength - 2; offsetB++) {
            int Bfrom = offsetB;
            int Bend = Bfrom + blength - 1;

            int comFrom = Math.max(Afrom, Bfrom);
            int comEnd = Math.min(Aend, Bend);

            int comLength = comEnd - comFrom + 1;

            if (maxCommonLength < comLength) {
                int maxSameLength = maxSameLength(A, offsetA, B, offsetB, comFrom, comEnd);
                maxCommonLength = Math.max(maxCommonLength, maxSameLength);
            }
        }

        return maxCommonLength;
    }

    private int maxSameLength(int[] a, int offsetA, int[] b, int offsetB, int comFrom, int comEnd) {
        int commonLength = 0;
        int maxCommonLength = 0;
        for (int i = comFrom; i <= comEnd; i++) {
            int elementA = a[i - offsetA];
            int elementB = b[i - offsetB];
            if (elementA == elementB) {
                commonLength += 1;
            } else {
                commonLength = 0;
            }
            maxCommonLength = Math.max(maxCommonLength, commonLength);
        }
        return maxCommonLength;
    }
}
