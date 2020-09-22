package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 找左右两边第一个比自己小的元素
 *
 * @author fzhang
 * @date 2020-09-22
 */
public class Solution84 {
    public static void main(String[] args) {
        int[] ints = {2, 1, 5, 6, 2, 3};
        Solution84 solution84 = new Solution84();
        int area = solution84.largestRectangleArea1(ints);
        System.out.println("area = " + area);
    }

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * @param heights 柱状图中各柱子高度数组
     * @return 柱状图中最大的矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 单调（非严格）递增栈
        LinkedList<Integer> deque = new LinkedList<>();
        int length = heights.length;

        int maxSquare = Integer.MIN_VALUE;

        // 添加左边哨兵
        deque.offerLast(-1);
        // 添加右边哨兵（注意：i = heights.length）
        for (int i = 0; i <= length; i++) {
            while (getHeight(heights, deque.peekLast()) > getHeight(heights, i)) {
                Integer pollLast = deque.pollLast();
                int height = getHeight(heights, pollLast);
                Integer left = deque.peekLast();
                int width = i - left - 1;
                int square = height * width;
                maxSquare = Math.max(maxSquare, square);
            }
            deque.offerLast(i);
        }
        return maxSquare;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 单调（非严格）递增栈
        LinkedList<Integer> stack = new LinkedList<>();
        int length = heights.length;

        // 用于保存当前柱子左边第一个高度小于自己的柱子索引
        int[] left = new int[length];

        // 用于保存当前柱子左边第一个高度小于自己的柱子索引
        int[] right = new int[length];

        // 添加左边哨兵
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            Integer peek = stack.peek();
            int pHeight = getHeight(heights, peek);

            if (pHeight < heights[i]) {
                // 当前栈顶元素的高度 < 新加入元素高度
                left[i] = peek;
            } else if (pHeight == heights[i]) {
                // 当前栈顶元素的高度 == 新加入元素高度
                left[i] = left[peek];
                // （其实相同的元素只需要考虑第一个出现的，因为所有元素形成的矩阵面积都是相同的）
            } else if (pHeight > heights[i]) {
                // 当前栈顶元素的高度 > 新加入元素高度

                // 弹出高度大于当前柱子的元素
                while (getHeight(heights, stack.peek()) > heights[i]) {
                    Integer pop = stack.pop();
                    right[pop] = i;
                }

                if (getHeight(heights, stack.peek()) < heights[i]) {
                    left[i] = stack.peek();
                } else if (getHeight(heights, stack.peek()) == heights[i]) {
                    left[i] = left[stack.peek()];
                }
            }
            stack.push(i);
        }

        // 添加右边哨兵
        while (getHeight(heights, stack.peek()) > getHeight(heights, length)) {
            Integer pop = stack.pop();
            right[pop] = length;
        }

        System.out.println("heights = " + Arrays.toString(heights));
        System.out.println("left = " + Arrays.toString(left));
        System.out.println("right = " + Arrays.toString(right));

        // 求最大面积
        int maxSquare = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int r = right[i];
            int l = left[i];
            int s = (r - l - 1) * heights[i];
            maxSquare = Math.max(maxSquare, s);
        }

        return maxSquare;
    }

    private int getHeight(int[] heights, Integer index) {
        if (index < 0 || index >= heights.length) {
            return -1;
        }
        return heights[index];
    }
}
