package leetcode;

/**
 * 53. 最大子序和
 *
 * @author fzhang
 * @date 2020-10-04
 */
public class Solution53 {
    public static void main(String[] args) {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution53 solution53 = new Solution53();
        int maxSubArray = solution53.maxSubArray(ints);
        System.out.println("maxSubArray = " + maxSubArray);
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums 整型数组
     * @return 最大连续子数组的和
     */
    public int maxSubArray(int[] nums) {
        int[] maxSubArray = dacMaxSubArray(nums, 0, nums.length - 1);
        int leftIndex = maxSubArray[0];
        int rightIndex = maxSubArray[1];
        int maxSum = maxSubArray[2];
        System.out.println("leftIndex = " + leftIndex);
        System.out.println("rightIndex = " + rightIndex);
        System.out.println("maxSum = " + maxSum);
        return maxSum;
    }

    /**
     * 整型数组 nums [left, right] 中最大连续子数组的和
     *
     * @param nums  整型数组
     * @param left  起始索引
     * @param right 终止索引
     * @return 最大连续子数组的和
     */
    private int[] dacMaxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{left, right, nums[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftRes = dacMaxSubArray(nums, left, mid);
        int[] rightRes = dacMaxSubArray(nums, mid + 1, right);
        int[] crossingRes = maxCrossingSubArray(nums, left, mid, right);

        int[] largestRes = leftRes;
        if (largestRes[2] < rightRes[2]) {
            largestRes = rightRes;
        }
        if (largestRes[2] < crossingRes[2]) {
            largestRes = crossingRes;
        }
        return largestRes;
    }

    private int[] maxCrossingSubArray(int[] nums, int left, int mid, int right) {
        int leftIndex = -1;
        int rightIndex = -1;
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }

        int maxCrossingSum = leftSum + rightSum;
        return new int[]{leftIndex, rightIndex, maxCrossingSum};
    }

    /**
     * 主要用到：贪心/动态规划 思想
     *
     * @param nums 整型数组
     * @return 最大连续子数组的和
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        // 记录以 nums[i] 为结尾的子数组的最大和
        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        int left = 0;
        int right = 0;
        maxSum = Math.max(maxSum, ints[0]);
        for (int i = 1; i < nums.length; i++) {
            // TODO: 10/4/20 这里更新 ints[i] 值用到了 ints[i-1]，因此可以将数组优化为只用单个变量
            // 这里体现 贪心/动态规划 思想
            if (ints[i - 1] > 0) {
                ints[i] = ints[i - 1] + nums[i];
                if (ints[i] > maxSum) {
                    maxSum = ints[i];
                    right = i;
                }
            } else {
                ints[i] = nums[i];
                if (ints[i] > maxSum) {
                    maxSum = ints[i];
                    right = i;
                    left = i;
                }
            }
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("maxSum = " + maxSum);
        return maxSum;
    }

    /**
     * 暴力/枚举 方法
     *
     * @param nums 整型数组
     * @return 最大连续子数组的和
     */
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("maxSum = " + maxSum);
        return maxSum;
    }
}
