package nowcode;

public class Solution_JZ10 {

    /**
     * 动态规划，避免重复子问题
     */
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }

        int[] result = new int[target + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[target];
    }

    /**
     * 递归调用，复杂度较高
     */
    public int RectCover1(int target) {
        if (target <= 0) {
            return 0;
        }
        return rectCover(target);
    }

    public int rectCover(int target) {
        if (target < 0) {
            return 0;
        }
        if (target <= 1) {
            return 1;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }
}
