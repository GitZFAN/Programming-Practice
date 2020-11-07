package jobsCodeExam2020.jd;

import java.util.Scanner;

/**
 * 道具的魅力值（价值）
 *
 * @author 13585
 * @date 2020-09-17
 */
public class Solution1 {

    public static void main(String[] args) {
        // 输入样例：
        // 3 10
        //2 2 3
        //1 5 10
        //2 4 12
        // 样例输出：27
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] split1 = line1.split(" ");
        // 道具总数
        int n = Integer.parseInt(split1[0]);
        // 拥有的钱的总数
        int p = Integer.parseInt(split1[1]);

        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            // 道具i 的 数量
            ints[i][0] = Integer.parseInt(split[0]);
            // 道具i 的 价格
            ints[i][1] = Integer.parseInt(split[1]);
            // 道具i 的 价值
            ints[i][2] = Integer.parseInt(split[2]);
        }

        int[][] result = new int[n][p + 1];
        // 初始化第一层
        for (int i = 1; i <= p; i++) {
            // i 表示钱的数量
            if (i >= ints[0][1]) {
                // 有资格购买 道具0
                if ((i / ints[0][1]) < ints[0][0]) {
                    result[0][i] = (i / ints[0][1]) * ints[0][2];
                } else {
                    result[0][i] = ints[0][0] * ints[0][2];
                }
            }
        }

        // 开始迭代后续层
        for (int i = 1; i < n; i++) {
            // i 表示当前道具
            for (int j = 1; j <= p; j++) {
                // j 表示钱的数量
                if (j >= ints[i][1]) {
                    // 钱 超过 当前道具i 的价格
                    int maxP = Integer.MIN_VALUE;
                    // 最多能买 num 个 i 道具
                    int num = j / ints[i][1];
                    if (num < ints[i][0]) {
                        for (int k = 0; k <= num; k++) {
                            int beauty = k * ints[i][2] + result[i - 1][j - k * ints[i][1]];
                            maxP = Math.max(maxP, beauty);
                        }
                    } else {
                        for (int k = 0; k <= ints[i][0]; k++) {
                            int beauty = k * ints[i][2] + result[i - 1][j - k * ints[i][1]];
                            maxP = Math.max(maxP, beauty);
                        }
                    }

                    if (maxP > 0) {
                        result[i][j] = maxP;
                    }
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        System.out.println(result[n - 1][p]);
    }
}
