package jobsCodeExam2020.haluo;

/**
 * @author 13585
 * @date 2020-10-30
 */
public class Solution2 {
    /**
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int[] a) {
        // write code here
        for (int i = a.length - 1; i >= 0; i--) {
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            if (i != a.length - 1) {
                right = a[i+1];
            }
            if (i != 0) {
                left = a[i-1];
            }
            if (a[i] >= left && a[i] >= right) {
                return i;
            }
        }
        return 0;
    }
}
