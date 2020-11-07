package jobsCodeExam2020.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-10-26
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        int[] ints = new int[3];
        for (int i = 0; i < nums; i++) {
            ints[0] = scanner.nextInt();
            ints[1] = scanner.nextInt();
            ints[2] = scanner.nextInt();
            hasResult(ints);
        }
    }

    private static void hasResult(int[] ints) {
        Arrays.sort(ints);
        if (ints[2] == ints[1]) {
            System.out.println("YES");
            System.out.println(ints[1] + " " + ints[0] + " " + ints[0]);
        } else {
            System.out.println("NO");
        }
    }
}
