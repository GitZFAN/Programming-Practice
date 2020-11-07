package jobsCodeExam2020.haoweilai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            int[] ints = new int[length];
            for (int i = 0; i < length; i++) {
                ints[i] = scanner.nextInt();
            }

            Arrays.sort(ints);

            for (int i = ints.length - 1; i >= 1; i--) {
                System.out.print(ints[i] + " ");
            }
            System.out.println(ints[0]);
        }
    }
}
