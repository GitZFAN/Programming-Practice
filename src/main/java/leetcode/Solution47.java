package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution47 {

    int[] numbers;
    LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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

    private void swap(int index, int i) {
        int number = numbers[index];
        numbers[index] = numbers[i];
        numbers[i] = number;
    }
}
