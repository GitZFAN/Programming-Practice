package jobsCodeExam2020.meituan;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution3_1 {
    public static final int MOD = 998244353;
    public static int count = 0;

    static int n;
    static int k;
    static int d;

    public static void main(String[] args) {
        // 测试样例：
        // 填入的所有数必须小于等于k，大于等于1，填入的数的最大值必须大于等于d。
        // （1≤d≤k≤n≤1000）
        // 5 3 2
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        d = scanner.nextInt();

        // 动态规划
        int[][] ints = new int[k + 1][n + 1];

        for (int i = d; i <= k; i++) {

        }

        System.out.println(count);
    }
}
