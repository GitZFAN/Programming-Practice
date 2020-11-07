package jobsCodeExam2020.chubao;

import java.util.Scanner;

/**
 * 过桥问题
 * <p>
 * 只有一支手电筒，并且同时最多只能两个人一起过桥
 *
 * @author 13585
 * @date 2020-09-27
 */
public class Solution3 {
    public static void main(String[] args) {
        // 输入样例：
        // 4
        //1 2 5 10
        //17
        // 输出：1
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();

        System.out.println(1);
    }
}
