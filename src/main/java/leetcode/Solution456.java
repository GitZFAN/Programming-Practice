package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 456. 132 模式
 *
 * @author fzhang
 * @date 2021-03-25
 */
public class Solution456 {
    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。
     * 132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
     * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * <p>
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * <p>
     * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
     * <p>
     * <p>
     * 方法一：使用暴力维护 3
     *
     * @param nums 整数数组
     * @return 数组中是否存在 132 模式的子序列
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        } else {
            // 记录左边最小数(1)为 num1
            int num1 = nums[0];
            // 遍历中间最大数(3) nums[i]
            for (int i = 1; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (num1 < nums[j] && nums[j] < nums[i]) {
                        return true;
                    }
                }
                // 更新左边最小数(1)
                num1 = Math.min(num1, nums[i]);
            }
        }
        return false;
    }

    /**
     * 方法二：使用单调栈维护 3
     *
     * @param nums 整数数组
     * @return 数组中是否存在 132 模式的子序列
     */
    public boolean find132patternPro(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        } else {
            // 维护一个单调(非严格)递减栈
            Deque<Integer> stack = new LinkedList<>();
            // 记录被弹出的最大数 k
            int k = Integer.MIN_VALUE;

            // 操作最后两个元素
            stack.push(nums[nums.length - 1]);
            if (nums[nums.length - 2] > stack.peek()) {
                k = Math.max(k, stack.pop());
            }
            if (stack.isEmpty() || nums[nums.length - 2] < stack.peek()) {
                stack.push(nums[nums.length - 2]);
            }


            for (int i = nums.length - 3; i >= 0; i--) {
                if (nums[i] < k) {
                    return true;
                } else {
                    while (!stack.isEmpty()) {
                        if (nums[i] > stack.peek()) {
                            k = Math.max(k, stack.pop());
                        } else {
                            break;
                        }
                    }
                    if (stack.isEmpty() || nums[i] < stack.peek()) {
                        stack.push(nums[i]);
                    }
                }
            }
        }
        return false;
    }
}
