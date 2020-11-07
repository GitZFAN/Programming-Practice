package jobsCodeExam2020.haluo;

/**
 * @author 13585
 * @date 2020-10-30
 */
public class Solution1 {
    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        // write code here
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
