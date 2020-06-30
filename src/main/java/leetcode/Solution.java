package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {2,4,6,8,8,2,6,4};

        Solution solution = new Solution();
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);
        for (Integer disNum :
                disappearedNumbers) {
            System.out.print(disNum + " ");
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (nums[absNum-1] > 0) {
                nums[absNum-1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
