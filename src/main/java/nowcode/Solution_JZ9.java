package nowcode;

import java.util.Arrays;

public class Solution_JZ9 {
    public static void main(String[] args) {
        Solution_JZ9 solution_jz9 = new Solution_JZ9();
        int jumpFloorII = solution_jz9.JumpFloorII(4);
        System.out.println("result:" + jumpFloorII);
    }

    public int JumpFloorII(int target) {
        // TODO 分析总结规律后得到的最简方法
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }

    public int JumpFloorII2(int target) {
        // TODO 思考是否有优化空间复杂度的解决方法
        if (target <= 0) {
            return 0;
        }
        int[] result = new int[target + 1];
        Arrays.fill(result, 1);
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j < i; j++) {
                result[i] += result[i - j];
            }
        }

        return result[target];
    }

    /**
     * 动态规划，使用O(n^2)空间复杂度
     *
     * @param target 目标规模n
     * @return 返回结果
     */
    public int JumpFloorII1(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        }
        int[][] result = new int[target + 1][target + 1];

        for (int i = 1; i <= target; i++) {
            result[1][i] = 1;
            result[i][1] = 1;
        }
        for (int i = 2; i < result.length; i++) {
            for (int j = 2; j < result[i].length; j++) {
                if (i < j) {
                    result[i][j] = result[i][i];
                } else if (i == j) {
                    result[i][j] = 1 + result[i][j - 1];
                } else {
                    // 下面这一步不需要考虑，因为会和下面循环中的情况产生重叠。
                    // result[i][j] = result[i][j-1];
                    for (int k = 1; k <= j; k++) {
                        result[i][j] += result[i - k][j];
                    }
                }
            }
        }
        return result[target][target];
    }
}
