package jobsCodeExam2020.shangjiaosuo;

import java.util.Scanner;

/**
 * 求下一个前三位和等于后三位的6位数
 *
 * @author 13585
 * @date 2020-10-24
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        int pre = anInt / 1000;
        int post = anInt % 1000;
        int sum = countSum(pre);

        for (int i = post + 1; i < 999; i++) {
            int countSum = countSum(i);
            if (countSum(i) == sum) {
                System.out.println(pre * 1000 + i);
                return;
            }
        }
    }

    private static int countSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
