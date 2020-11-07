package jobsCodeExam2020.chubao;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-27
 */
public class Solution4 {
    public static int minRelax = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] english = new int[num];
        int[] math = new int[num];

        int[] status = new int[num];
        int remain = num;
        int relax = 0;

        for (int i = 0; i < num; i++) {
            english[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            math[i] = scanner.nextInt();
            if (math[i] == 0) {
                if (english[i] == 0) {
                    // 休息
                    status[i] = 3;
                    relax += 1;
                } else {
                    // 英语
                    status[i] = 1;
                }
                remain -= 1;
            } else {
                if (english[i] == 0) {
                    // 数学
                    status[i] = 2;
                    remain -= 1;
                } else {
                    // 不确定

                }
            }
        }

        dfs(0, relax, remain, status);

        System.out.println(minRelax);
    }

    private static void dfs(int startIndex, int relax, int remain, int[] status) {
        if (remain == 0) {
            int sum = 0;
            for (int i : status) {
                if (i == 3) {
                    sum += 1;
                }
            }
            minRelax = Math.min(minRelax, sum);
        }

        for (int i = startIndex; i < status.length; i++) {
            if (relax > minRelax) {
                break;
            }
            if (status[i] == 0) {
                // 不确定
                if ((i - 1) < 0 || status[i - 1] != 1) {
                    if ((i + 1) >= status.length || status[i + 1] != 1) {
                        status[i] = 1;
                        dfs(i + 1, relax, remain - 1, status);
                        status[i] = 0;
                    }
                }

                if ((i - 1) < 0 || status[i - 1] != 2) {
                    if ((i + 1) >= status.length || status[i + 1] != 2) {
                        status[i] = 2;
                        dfs(i + 1, relax, remain - 1, status);
                        status[i] = 0;
                    }
                }

                status[i] = 3;
                dfs(i + 1, relax + 1, remain - 1, status);
                status[i] = 0;
            }
        }
    }
}
