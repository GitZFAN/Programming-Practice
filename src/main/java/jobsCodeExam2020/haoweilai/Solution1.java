package jobsCodeExam2020.haoweilai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 测试样例 2,45,34,57,23,31,20,42,65

        String line = scanner.nextLine();
        String[] split = line.split(",");
        int[] ints = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        int length = ints.length;
        int oddIndex = 0;
        int evenIndex = length - 1;

        for (int i = 0; i <= evenIndex; ) {
            if (ints[i] % 2 == 0) {
                // 偶数
                int temp = ints[i];
                ints[i] = ints[evenIndex];
                ints[evenIndex] = temp;

                while (evenIndex >= 0) {
                    if (ints[evenIndex] % 2 == 0) {
                        evenIndex--;
                    } else {
                        break;
                    }
                }
            } else {
                oddIndex += 1;
                while (oddIndex < length) {
                    if (ints[oddIndex] % 2 != 0) {
                        oddIndex += 1;
                    } else {
                        break;
                    }
                }
                i = oddIndex;
            }
        }

        System.out.println(Arrays.toString(ints));
    }
}
