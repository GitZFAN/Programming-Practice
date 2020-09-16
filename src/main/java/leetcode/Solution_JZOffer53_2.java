package leetcode;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author 13585
 * @date 2020-09-16
 * @see Solution34#leftBound(int[], int) 二分左边界查找
 */
public class Solution_JZOffer53_2 {
    /**
     * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * <p>
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * @param nums 长度为 n-1 的递增排序数组，每个数字都在范围0～n-1之内
     * @return 范围0～n-1内的n个数字中有且只有一个数字不在该数组中，返回这个数字
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        // 搜索区间：[left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] != mid) {
                right = mid;
            }
        }

        return left;
    }
}
