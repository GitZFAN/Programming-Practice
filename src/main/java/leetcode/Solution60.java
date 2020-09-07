package leetcode;

import java.util.LinkedList;

/**
 * 60. 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * </p>
 *
 * @author fzhang
 * @date 2020-09-06
 */
public class Solution60 {
    StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        System.out.println("solution60.factorial(5) = " + solution60.factorial(5));

        System.out.println("solution60.getPermutation(3, 3) = " + solution60.getPermutation(3, 3));
        solution60.stringBuilder.delete(0, solution60.stringBuilder.length());
        System.out.println("solution60.getPermutation(4, 12) = " + solution60.getPermutation(4, 12));
        solution60.stringBuilder.delete(0, solution60.stringBuilder.length());
        System.out.println("solution60.getPermutation(3, 2) = " + solution60.getPermutation(3, 2));
    }

    /**
     * 给定 n 和 k，返回第 k 个排列。
     *
     * @param n 集合 [1,2,3,…,n]
     * @param k 第 k 个排列
     * @return 第 k 个排列的具体内容
     */
    public String getPermutation(int n, int k) {
        if (n < 1) {
            return "";
        } else if (n == 1) {
            return "1";
        }
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            integers.add(i);
        }

        permutation(integers, k);

        return stringBuilder.toString();
    }

    private void permutation(LinkedList<Integer> list, int k) {
        int size = list.size();
        if (size == 2) {
            if (k == 1) {
                stringBuilder.append(list.get(0));
                stringBuilder.append(list.get(1));
            } else {
                stringBuilder.append(list.get(1));
                stringBuilder.append(list.get(0));
            }
            return;
        }

        // 得到 k 个排列的第一个元素
        int classifyNum = factorial(size - 1);
        int divide = k / classifyNum;
        int remain = k % classifyNum;

        int thisStep;
        int nextStep;
        if (remain != 0) {
            thisStep = divide;
            nextStep = remain;
        } else {
            thisStep = divide - 1;
            nextStep = classifyNum;
        }

        stringBuilder.append(list.get(thisStep));
        list.remove(thisStep);

        permutation(list, nextStep);
    }

    /**
     * 递归方式 求 k! 的值
     *
     * @param k 整数
     * @return k!值
     */
    private int factorial(int k) {
        if (k == 0) {
            return 1;
        }
        return k * factorial(k - 1);
    }
}
