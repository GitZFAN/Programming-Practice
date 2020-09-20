package mytool.permutationAndCombinationAndSubset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution47 {

    int[] numbers;
    LinkedList<List<Integer>> result = new LinkedList<>();

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * @param nums 可包含重复数字的序列
     * @return 所有不重复的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        numbers = nums;

        if (nums == null || nums.length == 0) {
            return null;
        }

        // 从第一个元素开始排
        permuteFromIndex(0);

        return result;
    }

    private void permuteFromIndex(int index) {
        if (index == numbers.length - 1) {
            ArrayList<Integer> integers = new ArrayList<>(numbers.length);
            for (int number : numbers) {
                integers.add(number);
            }
            result.add(integers);
            return;
        }

        // 使用 HashSet 避免重复，因为排列不需要考虑重复元素之间的顺序
        HashSet<Integer> hashSet = new HashSet<>();
        // 对当前下标至末尾的所有数组元素进行排列
        for (int i = index; i < numbers.length; i++) {
            int number = numbers[i];
            if (!hashSet.contains(number)) {
                hashSet.add(number);
                swap(index, i);
                permuteFromIndex(index + 1);
                swap(index, i);
            }
        }
    }

    /**
     * 通过 交换，实现 <b>记录已经访问的路径，并且划分 已访问 和 未访问 的元素集合</b>
     * 减少时间和空间代价
     *
     * @param index 进行交换的第一个元素 索引
     * @param i     进行交换的第二个元素 索引
     */
    private void swap(int index, int i) {
        int number = numbers[index];
        numbers[index] = numbers[i];
        numbers[i] = number;
    }
}
