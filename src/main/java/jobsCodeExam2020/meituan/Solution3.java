package jobsCodeExam2020.meituan;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution3 {
    public static final int MOD = 998244353;
    public static int count = 0;

    static int n;
    static int k;
    static int d;

    public static void main(String[] args) {
        // 测试样例：
        // 5 3 2
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        d = scanner.nextInt();


        dfs(n, 0);

        System.out.println(count);
    }

    private static void dfs(int remainValue, int maxValue) {
        if (remainValue == 0) {
            if (maxValue >= d) {
                count += 1;
                if (count >= MOD) {
                    count %= MOD;
                }
            }
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (i <= remainValue) {

                if (i > maxValue) {
                    maxValue = i;
                }
                dfs(remainValue - i, maxValue);

            } else {
                break;
            }
        }
    }
}
