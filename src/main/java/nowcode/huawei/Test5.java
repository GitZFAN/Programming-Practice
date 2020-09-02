package nowcode.huawei;

import java.util.Scanner;

/**
 * 华为I/O练习
 * 整数求和
 *
 * @author 13585
 * @date 2020-09-01
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nextIntNum = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < nextIntNum; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
            /*String s = scanner.nextLine();
            String[] split = s.split(" ");

            for (String s1 : split) {
                sum += Integer.parseInt(s1);
            }
            System.out.println(sum);*/
        }
    }
}
