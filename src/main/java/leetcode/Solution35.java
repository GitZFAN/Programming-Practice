package leetcode;

/**
 * 35. 搜索插入位置
 *
 * @author 13585
 * @date 2020-09-22
 * @see Solution34 二分边界查找
 */
public class Solution35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 返回目标值索引；如果目标值不存在，返回它将会被按顺序插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 搜索区间 [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left;
    }
}
