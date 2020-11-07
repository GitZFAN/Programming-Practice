package jobsCodeExam2020.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(ints);

        System.out.println(ints[ints.length / 2]);
    }
}
