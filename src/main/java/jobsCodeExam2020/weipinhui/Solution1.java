package jobsCodeExam2020.weipinhui;

import java.util.Scanner;

/**
 * 整数反转
 *
 * @author 13585
 * @date 2020-09-18
 * @see leetcode.Solution7 7. 整数反转
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        int result = 0;
        while (anInt != 0) {
            int r = anInt % 10;
            // 这里需要判断result是否会溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > 7)) {
                System.out.println(0);
                break;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && r < -8)) {
                System.out.println(0);
                break;
            }

            result = result * 10 + r;

            anInt /= 10;
        }

        System.out.println(result);
    }
}
