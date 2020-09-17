package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * @author 13585
 * @date 2020-09-15
 */
public class Solution_JZOffer59_1 {
    public static void main(String[] args) {
        int[] ints = {4, 3, 11};
        int k = 3;
        Solution_JZOffer59_1 solution_jzOffer59_1 = new Solution_JZOffer59_1();
        int[] ints1 = solution_jzOffer59_1.maxSlidingWindow(ints, k);
        System.out.println("ints1 = " + Arrays.toString(ints1));
    }

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * @param nums 数组
     * @param k    滑动窗口大小
     * @return 所有滑动窗口里的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;
        // 滑动窗口变化范围：[0, k-1] -> [length-1-k+1, length-1]
        int[] result = new int[length - k + 1];

        // 辅助队列：非严格递减，单调队列（Deque实现）
        Deque<Integer> supDeque = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            int left = i - k + 1;
            // 窗口区间 [left, i]

            // 1. 增加 nums[i]
            while (!supDeque.isEmpty()) {
                if (supDeque.peekLast() < nums[i]) {
                    supDeque.pollLast();
                } else {
                    break;
                }
            }
            supDeque.offerLast(nums[i]);

            // 2. 移除 nums[left-1]
            if (left > 0) {
                // 即 left-1 >= 0
                if (nums[left - 1] == supDeque.peekFirst()) {
                    supDeque.pollFirst();
                }
            }

            // 3. 记录 该窗口区间 [left, i] 的最大值 -> result[left]
            if (left >= 0) {
                result[left] = supDeque.peekFirst();
            }
        }
        return result;
    }
}
