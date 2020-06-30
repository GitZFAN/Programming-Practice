package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1248 {
    public static void main(String[] args) {
        Solution1248 solution1248 = new Solution1248();
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int numberOfSubarrays = solution1248.numberOfSubarrays(nums, k);
        System.out.println(numberOfSubarrays);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                oddIndexes.add(i);
            }
        }

        if (oddIndexes.size() < k) {
            return 0;
        } else {
            int result = 0;
            for (int i = k-1; i < oddIndexes.size(); i++) {
                int front = oddIndexes.get(i + 1 - k);
                int end = oddIndexes.get(i);

                int frontPossibility = 1;
                for (int j = front-1; j >= 0; j--) {
                    if (nums[j] % 2 == 0) {
                        frontPossibility += 1;
                    } else {
                        break;
                    }
                }
                int endPossibility = 1;
                for (int j = end+1; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        endPossibility += 1;
                    } else {
                        break;
                    }
                }

                result += frontPossibility * endPossibility;
            }
            return result;
        }
    }
}
