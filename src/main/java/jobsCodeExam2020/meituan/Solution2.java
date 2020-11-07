package jobsCodeExam2020.meituan;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution2 {
    public static void main(String[] args) {
        // 测试样例：
        // 8 2 5
        //5 5 5 4 5 5 5 5
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i + m - 1 < n; i++) {
            if (validIndex(ints, i, i + m - 1, k)) {
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static boolean validIndex(int[] ints, int fromIndex, int endIndex, int minValue) {
        for (int i = fromIndex; i <= endIndex; i++) {
            if (ints[i] < minValue) {
                return false;
            }
        }
        return true;
    }
}
