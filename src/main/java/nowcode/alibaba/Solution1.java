package nowcode.alibaba;

import java.util.Scanner;

/**
 * 关键字搜索
 *
 * @author 13585
 * @date 2020-09-11
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            String line = scanner.nextLine();

            int num = 0;
            for (int i = 0; i < m; i++) {
                String word = scanner.nextLine();
                num += countNum(line, word);
            }

            System.out.println(num);
        }
    }

    private static int countNum(String line, String word) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            int index = line.indexOf(word, i);
            if (index != -1) {
                count += 1;
                i = index;
            }
        }
        return count;
    }
}
