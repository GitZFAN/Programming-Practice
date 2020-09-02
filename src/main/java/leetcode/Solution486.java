package leetcode;

/**
 * 486. 预测赢家
 *
 * @author fzhang
 * @date 2020-09-01
 */
public class Solution486 {
    public static void main(String[] args) {
        int[] ints = {3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512, 753594, 5474165, 4, 2697293, 8, 7, 1};
        Solution486 solution486 = new Solution486();
        boolean canFirstHandWin = solution486.PredictTheWinner(ints);
        System.out.println("canFirstHandWin = " + canFirstHandWin);
    }

    /**
     * 递归
     *
     * @param nums 分数数组
     * @return 先手玩家是否能获胜
     */
    public boolean PredictTheWinner(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int score1 = 0;
        int score2 = 0;

        int[] ints = playGame(nums, start, end, 0, score1, score2);

        return ints[0] >= ints[1];
    }

    private int[] playGame(int[] nums, int start, int end, int turn, int score1, int score2) {
        if (start == end) {
            if (turn % 2 == 0) {
                // 先手
                score1 += nums[start];
            } else {
                // 后手
                score2 += nums[start];
            }
            return new int[]{score1, score2};
        }

        if (turn % 2 == 0) {
            // 先手

            // 拿左边
            int[] left = playGame(nums, start + 1, end, turn + 1, score1 + nums[start], score2);
            // 拿右边
            int[] right = playGame(nums, start, end - 1, turn + 1, score1 + nums[end], score2);

            if (left[0] < right[0]) {
                return right;
            } else {
                return left;
            }

        } else {
            // 后手

            // 拿左边
            int[] left = playGame(nums, start + 1, end, turn + 1, score1, score2 + nums[start]);
            // 拿右边
            int[] right = playGame(nums, start, end - 1, turn + 1, score1, score2 + nums[end]);

            if (left[1] < right[1]) {
                return right;
            } else {
                return left;
            }
        }

    }

    public boolean PredictTheWinner1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 先考虑 拿头部的情况
            int headResult = Math.max(nums[start + 1], nums[end]);

            // 再考虑 拿尾部的结果
            int tailResult = Math.max(nums[start], nums[end - 1]);

            if (Math.abs(nums[start] - nums[end]) < Math.abs(headResult - tailResult)) {
                if (headResult < tailResult) {
                    // 取头部节点
                    if (i % 2 == 0) {
                        sum1 += nums[start];
                    } else {
                        sum2 += nums[start];
                    }
                    start += 1;
                } else {
                    // 取尾部节点
                    if (i % 2 == 0) {
                        sum1 += nums[end];
                    } else {
                        sum2 += nums[end];
                    }
                    end -= 1;
                }
            } else {
                if (nums[start] > nums[end]) {
                    // 取头部节点
                    if (i % 2 == 0) {
                        sum1 += nums[start];
                    } else {
                        sum2 += nums[start];
                    }
                    start += 1;
                } else {
                    // 取尾部节点
                    if (i % 2 == 0) {
                        sum1 += nums[end];
                    } else {
                        sum2 += nums[end];
                    }
                    end -= 1;
                }
            }
        }

        // 剩下最后一个，判断最后分配给谁
        if (nums.length % 2 == 0) {
            sum2 += nums[start];
        } else {
            sum1 += nums[start];
        }

        return sum1 >= sum2;
    }
}
