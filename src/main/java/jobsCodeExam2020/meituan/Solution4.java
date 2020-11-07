package jobsCodeExam2020.meituan;

import java.util.Scanner;

/**
 * 齿轮旋转
 *
 * @author 13585
 * @date 2020-09-13
 */
public class Solution4 {
    public static final int MOD = 998244353;
    static int count = 0;

    public static void main(String[] args) {
        // 输入样例：
        // 2
        //BB
        //3
        //ABA
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line1 = scanner.nextLine();
            Integer num = Integer.valueOf(line1);
            String line2 = scanner.nextLine();
            char[] chars = new char[line2.length()];
            for (int i = 0; i < line2.length(); i++) {
                chars[i] = line2.charAt(i);
            }

            int sum = 0;
            for (int i = 0; i < chars.length; i++) {
                count = 0;
                dfs(chars, i);
                if (count >= MOD) {
                    count %= MOD;
                }
                sum += count;
                if (sum >= MOD) {
                    sum %= MOD;
                }
            }
        }
    }

    private static void dfs(char[] chars, int startIndex) {

    }
}
