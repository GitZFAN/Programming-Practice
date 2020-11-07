package jobsCodeExam2020.xiaomi;

import java.util.Scanner;

/**
 * 判断密码是否符合规范
 *
 * @author 13585
 * @date 2020-09-08
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splits = line.split(" ");
            for (String split : splits) {
                if (!"".equals(split)) {
                    System.out.println(judge(split));
                }
            }
        }
    }

    private static int judge(String split) {
        if (split.length() < 8 || split.length() > 120) {
            return 1;
        }

        boolean hasNum = false;
        boolean hasSmall = false;
        boolean hasBig = false;
        boolean hasChar = false;
        for (int i = 0; i < split.length(); i++) {
            char c = split.charAt(i);
            if ('a' <= c && c <= 'z') {
                hasSmall = true;
                continue;
            }
            if ('A' <= c && c <= 'Z' ) {
                hasBig = true;
                continue;
            }
            if ('0' < c && c < '9') {
                hasNum = true;
                continue;
            }
            hasChar = true;
        }
        if (hasNum && hasBig && hasSmall && hasChar) {
            return 0;
        }
        return 2;
    }
}
