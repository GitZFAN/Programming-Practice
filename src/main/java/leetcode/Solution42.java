package leetcode;

import java.util.LinkedList;

/**
 * 42. 接雨水
 *
 * @author 13585
 * @date 2020-09-22
 */
public class Solution42 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution42 solution42 = new Solution42();
        int trap = solution42.trap(ints);
        System.out.println("trap = " + trap);
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 找左右两边第一个比自己大的元素
     *
     * @param height 排列的柱子高度图
     * @return 下雨之后能接多少雨水
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // 单调（非严格）递减栈
        LinkedList<Integer> deque = new LinkedList<>();

        int sum = 0;

        // 添加左边哨兵
        deque.offerLast(-1);
        for (int i = 0; i < height.length; i++) {
            while (deque.size() > 1) {
                if (getHeight(height, deque.peekLast()) < height[i]) {
                    Integer pollLast = deque.pollLast();
                    Integer left = deque.peekLast();
                    int width = i - left - 1;
                    int hgt = Math.min(getHeight(height, left), height[i]) - getHeight(height, pollLast);
                    if (hgt > 0) {
                        sum += width * hgt;
                    }
                } else {
                    break;
                }
            }
            deque.offerLast(i);
        }

        return sum;
    }

    private int getHeight(int[] height, int index) {
        if (index < 0 || index >= height.length) {
            return 0;
        }
        return height[index];
    }


    /**
     * 动态编程：记录左右两边最大值，然后遍历累加所有元素接水量
     *
     * @param height 排列的柱子高度图
     * @return 下雨之后能接多少雨水
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int length = height.length;

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        // 记录当前元素左边所有元素最大值
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // 记录当前元素右边所有元素最大值
        rightMax[length - 1] = rightMax[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int sum = 0;
        // 遍历累加所有元素接水量
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
