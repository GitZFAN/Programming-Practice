package jobsCodeExam2020.vivo;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        for (int i = -1; i < line.length(); i++) {
            if (isValid(line, i)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < line.length(); j++) {
                    if (j != i) {
                        stringBuilder.append(line.charAt(j));
                    }
                }
                System.out.println(stringBuilder.toString());
                return;
            }
        }
        System.out.println("false");
    }

    private static boolean isValid(String line, int notIndex) {
        int pre = 0;
        int post = line.length() - 1;
        while (pre <= post) {
            if (pre == notIndex) {
                pre += 1;
                continue;
            }
            if (post == notIndex) {
                post -= 1;
                continue;
            }
            if (line.charAt(pre) != line.charAt(post)) {
                return false;
            }
            pre += 1;
            post -= 1;
        }
        return true;
    }
}
