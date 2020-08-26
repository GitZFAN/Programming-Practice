package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 *
 * @author fzhang
 * @date 2020-08-25
 */
public class Solution491 {

    public static int value = 0;

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return new LinkedList<>();
        }

        return getSubsequences(nums, 0);
    }

    // DONE: 8/26/20 超出时间限制，需要优化时间复杂度
    // 增加了一个 HashMap 结构来帮助判断是否重复，比直接在 List 中判断重复的复杂度低

    private List<List<Integer>> getSubsequences(int[] nums, int index) {
        List<List<Integer>> result = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>(nums.length);

        // 初始情况
        if (index == nums.length - 2) {
            if (nums[index] <= nums[index + 1]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[index]);
                list.add(nums[index + 1]);
                result.add(list);
            }
            return result;
        }

        List<List<Integer>> subsequences = getSubsequences(nums, index + 1);
        if (subsequences.size() != 0) {
            result.addAll(subsequences);

            for (List<Integer> list : subsequences) {
                hashMap.put(list.toString(), value);
                value += 1;
            }

            // 先考虑和 subsequences 中的子序列进行拼接
            for (List<Integer> subsequence : subsequences) {
                // 判断能否构成递增
                if (nums[index] <= subsequence.get(0)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.addAll(subsequence);
                    if (!hashMap.containsKey(list.toString())) {
                        result.add(list);
                        hashMap.put(list.toString(), value);
                        value += 1;
                    }
                }
            }
        }

        // 然后考虑两个元素子序列情况
        for (int i = index + 1; i < nums.length; i++) {
            // 判断能否构成递增
            if (nums[index] <= nums[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[index]);
                list.add(nums[i]);
                if (!hashMap.containsKey(list.toString())) {
                    result.add(list);
                    hashMap.put(list.toString(), value);
                    value += 1;
                }
            }
        }

        return result;
    }
}
