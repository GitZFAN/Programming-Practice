package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 点游戏
 *
 * @author fzhang
 * @date 2020-08-22
 */
public class Solution679 {
    /**
     * 通过回溯的方法遍历所有不同的可能性
     * <p>
     * TODO: 8/22/20 经典 回溯算法 + 集合元素排列组合，copy from 题解，值的参考
     */

    static final int TARGET = 24;
    /**
     * 因为浮点数的特性，需要设置精度，以判断两数“相等”
     */
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        // 将输入的integer类型Array转化为double类型List
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        // 对一个list中取两个元素的方法：两层遍历
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    // 要求取出的元素不同
                    // list2 用于保存list中剩余元素 以及 取出的俩元素运算后结果
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            // 取出的元素 i,j 计算得到的结果相同，所以可以减去该分支
                            continue;
                        }

                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }

                        // 递归解决
                        if (solve(list2)) {
                            return true;
                        }
                        // 回溯
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
