package leetcode;

public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = {2,3,1,1,4};
        boolean canJump = solution55.canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int updateJump = i + num;

            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, updateJump);
        }
        return true;
    }

    /*public boolean canJump(int[] nums) {
        boolean[] isValid = new boolean[nums.length];
        isValid[0] = true;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (isValid[i]) {
                for (int j = 1; j <= num; j++) {
                    if (i+j < isValid.length) {
                        isValid[i+j] = true;
                    }
                }
            }
        }

        return isValid[nums.length-1];
    }*/
}
