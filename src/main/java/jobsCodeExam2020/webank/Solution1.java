package jobsCodeExam2020.webank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 磁铁
 *
 * @author 13585
 * @date 2020-10-15
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        for (int i = 0; i < ints.length - 1; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println(ints[ints.length - 1]);
    }
}
