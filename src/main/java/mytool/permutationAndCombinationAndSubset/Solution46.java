package mytool.permutationAndCombinationAndSubset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution46 {

    int[] numbers;
    LinkedList<List<Integer>> result = new LinkedList<>();

    /**
     * 对 nums 中的所有元素进行 全排列 ，返回所有排列集合
     *
     * @param nums 内含 <b>不重复</b> 元素集合
     * @return nums 中所有元素进行 全排列 的结果集合
     */
    public List<List<Integer>> permute(int[] nums) {
        numbers = nums;

        if (nums == null || nums.length == 0) {
            return null;
        }

        // 从 nums 第一个元素开始 排列
        permuteFromIndex(0);

        return result;
    }

    /**
     * 从 index 索引位置开始，对 {@link #numbers} 中的元素进行 全排列
     *
     * @param index 当前排列进行到的索引
     */
    private void permuteFromIndex(int index) {
        if (index == numbers.length - 1) {
            ArrayList<Integer> integers = new ArrayList<>(numbers.length);
            for (int number : numbers) {
                integers.add(number);
            }
            result.add(integers);
            return;
        }

        // 对当前下标至末尾的所有数组元素进行排列
        for (int i = index; i < numbers.length; i++) {
            // 因为数组中没有重复元素，所以无需考虑排列中存在重复情况
            swap(index, i);
            permuteFromIndex(index + 1);
            swap(index, i);
        }
    }

    /**
     * 交换 {@link #numbers} 序列中索引 index 和 i 所在两个元素
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
