package jobsCodeExam2020.beike;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-10-26
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int count = 0;
            for (int j = left; j <= right; j++) {
                if (isResult(j)) {
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isResult(int number) {
        int min = 9;
        int max = 0;
        while (number > 0) {
            int bit = number % 10;
            min = Math.min(min, bit);
            max = Math.max(max, bit);
            number /= 10;
        }
        return max <= min * 2;
    }
}
