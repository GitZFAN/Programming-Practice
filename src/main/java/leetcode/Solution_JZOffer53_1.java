package leetcode;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author 13585
 * @date 2020-09-16
 * @see Solution34 二分边界查找
 */
public class Solution_JZOffer53_1 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * @param nums   排序（升序）数组
     * @param target 目标值
     * @return 目标值在数组中出现的次数
     */
    public int search(int[] nums, int target) {
        Solution34 solution34 = new Solution34();
        int leftBound = solution34.leftBound(nums, target);
        if (leftBound == -1) {
            return 0;
        } else {
            int rightBound = solution34.rightBound(nums, target);
            return rightBound - leftBound + 1;
        }
    }
}
