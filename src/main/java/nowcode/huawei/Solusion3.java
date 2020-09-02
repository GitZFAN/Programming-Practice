package nowcode.huawei;

import java.util.Scanner;

/**
 * 0-1背包问题，但是有前提条件
 *
 * @author 13585
 * @date 2020-09-02
 */
public class Solusion3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextInt();
        }

        // 另一种解法
        backpack(K, weights, values);

        int[] dp = new int[1100];

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], (dp[j - weights[i]] + values[i]));
            }
        }

        System.out.println(dp[K]);

    }

    public static void backpack(int K, int[] weights, int[] values) {
        int[][] dp = new int[weights.length][K + 1];
        for (int i = 0; i <= K; i++) {
            if (i >= weights[0]) {
                dp[0][i] = values[0];
            }
        }
        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= K; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[weights.length - 1][K]);
    }
}
