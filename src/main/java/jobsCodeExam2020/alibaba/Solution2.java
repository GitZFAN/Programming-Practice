package jobsCodeExam2020.alibaba;

import java.util.*;

/**
 * 图像噪音修正
 *
 * @author 13585
 * @date 2020-09-11
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] ints = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ints[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ints[i][j] == -1) {
                        changeValue(ints, n, m, i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    System.out.print(ints[i][j] + " ");
                }
                System.out.println(ints[i][m - 1]);
            }
        }
    }

    private static void changeValue(int[][] ints, int row, int column,
                                    int index0, int index1) {
        // 广度搜索找出所有噪声快的整体位置
        boolean[][] used = new boolean[row][column];
        LinkedList<int[]> noise = new LinkedList<>();
        LinkedList<int[]> neighbor = new LinkedList<>();

        int[][] move = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        // 初始化第一个噪声的位置
        int[] location0 = {index0, index1};

        Deque<int[]> queue = new LinkedList<>();
        queue.offer(location0);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] value : move) {
                int nextIndex0 = poll[0] + value[0];
                int nextIndex1 = poll[1] + value[1];
                if (0 <= nextIndex0 && nextIndex0 < row) {
                    if (0 <= nextIndex1 && nextIndex1 < column) {
                        if (!used[nextIndex0][nextIndex1]) {
                            int[] location = {nextIndex0, nextIndex1};
                            if (ints[nextIndex0][nextIndex1] == -1) {
                                used[nextIndex0][nextIndex1] = true;
                                queue.offer(location);
                                noise.add(location);
                            } else {
                                used[nextIndex0][nextIndex1] = true;
                                neighbor.add(location);
                            }
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int[] loca : neighbor) {
            sum += ints[loca[0]][loca[1]];
        }
        int average = sum / neighbor.size();

        for (int[] loc : noise) {
            ints[loc[0]][loc[1]] = average;
        }
    }
}
