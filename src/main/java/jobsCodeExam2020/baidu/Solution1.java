package jobsCodeExam2020.baidu;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-14
 */
public class Solution1 {
    public static void main(String[] args) {
        // 测试样例：
        // 1
        //3 6
        //33 66 99
        //3 6 9 30 60 90
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] ints = new int[n];
            int[] result = new int[n];

            for (int j = 0; j < n; j++) {
                ints[j] = scanner.nextInt();
            }

            for (int j = 0; j < m; j++) {
                int anInt = scanner.nextInt();
                for (int k = 0; k < ints.length; k++) {
                    if (anInt >= ints[k]) {
                        result[k] += 1;
                    }
                }
            }

            for (int j = 0; j < result.length - 1; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println(result[result.length - 1]);
        }
    }
}
