package nowcode;

public class Solution_JZ7 {
    /**
     * dynamic programming
     * 动态规划
     */
    public int Fibonacci(int n) {
        int[] results = new int[40];
        results[0] = 0;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }

    /**
     * divide and conquer
     * 分治法
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
