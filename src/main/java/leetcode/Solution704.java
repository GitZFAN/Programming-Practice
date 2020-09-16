package leetcode;

/**
 * 704. 二分查找
 *
 * @author 13585
 * @date 2020-09-16
 * @see Solution34 二分边界查找
 */
public class Solution704 {

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums   元素有序的（升序）整型数组
     * @param target 目标值
     * @return 如果目标值存在返回下标，否则返回 -1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间：[left, right]
        while (left <= right) {
            // 另外声明一下，计算 mid 时需要防止溢出，
            // 代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，
            // 但是有效防止了 left 和 right 太大直接相加导致溢出。
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
