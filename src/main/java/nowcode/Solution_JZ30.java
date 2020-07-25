package nowcode;

public class Solution_JZ30 {
    /**
     * 贪心（剪枝），如果之前的序列和为负数，将当前节点作为子序列的头部，继续往后遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        /*if (array == null || array.length == 0) {
            return 0;
        }*/
        int cur = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (cur <= 0) {
                cur = array[i];
            } else {
                cur += array[i];
            }
            if (cur > maxSum) {
                maxSum = cur;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划，递推公式：F(n)=max(F(n-1)+array[n], array[n])。
     * 时间复杂度：O(n)，只需遍历一次array数组。
     * 空间复杂度：O(1),每次结果存储在array数组中，无需额外空间。使用一个变量记录每次结果中的最大值~
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        /*if (array == null || array.length == 0) {
            return 0;
        }*/
        int cur = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            res = Math.max(cur, res);
        }
        return res;
    }

    /**
     * 穷举方法，求出所有的子序列的和，找出其中最大值。
     * 时间复杂度：O(n^2)，不可取。
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        /*if (array == null || array.length == 0) {
            return 0;
        }*/
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int isum = 0;
            for (int j = i; j < array.length; j++) {
                isum += array[j];
                if (isum > maxSum) {
                    maxSum = isum;
                }
            }
        }
        return maxSum;
    }
}
