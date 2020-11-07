package jobsCodeExam2020.shencedata;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 13585
 * @date 2020-11-03
 */
public class Interview1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 12};

        Interview1 interview1 = new Interview1();
        int[] result = interview1.getResult(arr, 15);
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的那两个整数的数组下标
     */
    public int[] getResult(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (hashMap.containsKey(remain)) {
                return new int[]{i, hashMap.get(remain)};
            }
        }

        return null;
    }
}
