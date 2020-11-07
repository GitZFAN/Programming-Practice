package jobsCodeExam2020.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 华为I/O练习
 * 字符串排序
 *
 * @author 13585
 * @date 2020-09-01
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            Arrays.sort(split);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < split.length - 1; i++) {
                stringBuilder.append(split[i]);
                stringBuilder.append(",");
            }
            stringBuilder.append(split[split.length - 1]);
            System.out.println(stringBuilder.toString());
        }

    }
}
