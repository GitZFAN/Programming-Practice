package jobsCodeExam2020.vivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int startIndex0 = scanner.nextInt();
        int startIndex1 = scanner.nextInt();
        int endIndex0 = scanner.nextInt();
        int endIndex1 = scanner.nextInt();
        scanner.nextLine();

        int[][] ints = new int[length][length];
        for (int i = 0; i < length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char charAt = line.charAt(j);
                if (charAt == '#' || charAt == '@') {
                    ints[i][j] = 1;
                }
            }
        }

        for (int[] anInts : ints) {
            System.out.println(Arrays.toString(anInts));
        }

    }
}
