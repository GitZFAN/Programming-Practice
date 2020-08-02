package leetcode;

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

    public List<List<Integer>> permute(int[] nums) {
        numbers = nums;

        if (nums == null || nums.length == 0) {
            return null;
        }

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

        // 对当前下标至末尾的所有数组元素进行排列
        for (int i = index; i < numbers.length; i++) {
            // 因为数组中没有重复元素，所以无需考虑排列中存在重复情况
            swap(index, i);
            permuteFromIndex(index + 1);
            swap(index, i);
        }
    }

    private void swap(int index, int i) {
        int number = numbers[index];
        numbers[index] = numbers[i];
        numbers[i] = number;
    }
}
