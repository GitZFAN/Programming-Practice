package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * <p>
 * 找右边第一个比自己大的数字
 *
 * @author 13585
 * @date 2020-09-22
 */
public class Solution739 {
    public static void main(String[] args) {
        int[] ints = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("ints = " + Arrays.toString(ints));
        Solution739 solution739 = new Solution739();
        int[] dailyTemperatures = solution739.dailyTemperatures(ints);
        System.out.println("dailyTemperatures = " + Arrays.toString(dailyTemperatures));
    }

    /**
     * 请根据每日 气温 列表，重新生成一个列表。
     * <p>
     * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * @param temperatures 气温列表
     * @return 等待天数列表：重新生成一个列表
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int length = temperatures.length;
        int[] result = new int[length];

        // 单调（非严格）递减栈
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty()) {
                if (temperatures[deque.peekLast()] < temperatures[i]) {
                    Integer pollLast = deque.pollLast();
                    result[pollLast] = i - pollLast;
                } else {
                    break;
                }
            }
            deque.offerLast(i);
        }

        return result;
    }
}
