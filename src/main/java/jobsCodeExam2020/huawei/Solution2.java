package jobsCodeExam2020.huawei;

import java.util.*;

/**
 * 矩阵BFS问题
 *
 * @author 13585
 * @date 2020-09-02
 */
public class Solution2 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int M, N;
        String[] split = firstLine.split(",");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        char[][] chars = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                chars[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'S') {
                    changeChar(chars, i, j);
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }

    private static void changeChar(char[][] chars, int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        chars[i][j] = 'X';
        queue.offer(new int[]{i, j});
        int[][] move = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            for (int k = 0; k < 4; k++) {
                int first = index[0] + move[k][0];
                int second = index[1] + move[k][1];
                if (0 <= first && first < chars.length) {
                    if (0 <= second && second < chars[first].length) {
                        if (chars[first][second] == 'S') {
                            chars[first][second] = 'X';
                            queue.offer(new int[]{first, second});
                        }
                    }
                }
            }
        }
    }
}
