package jobsCodeExam2020.jd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 矩阵两点是否可达
 *
 * @author 13585
 * @date 2020-09-17
 */
public class Solution2 {
    public static void main(String[] args) {
        // 输入样例：
        // 2
        //2 2
        //.E
        //S.
        //2 2
        //#E
        //S#
        // 样例输出：
        // YES
        // NO
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        // 输入组数
        int num = Integer.parseInt(line1);
        for (int i = 0; i < num; i++) {
            // 每组输入第一行：n m
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int row = Integer.parseInt(split[0]);
            int column = Integer.parseInt(split[1]);

            int startIndex0 = -1;
            int startIndex1 = -1;
            char[][] chars = new char[row][column];
            for (int j = 0; j < row; j++) {
                String s = scanner.nextLine();
                for (int k = 0; k < s.length(); k++) {
                    chars[j][k] = s.charAt(k);
                    if (s.charAt(k) == 'S') {
                        startIndex0 = j;
                        startIndex1 = k;
                    }
                }
            }

            if (tourch(chars, startIndex0, startIndex1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean tourch(char[][] chars, int startIndex0, int startIndex1) {
        int row = chars.length;
        int column = chars[0].length;
        boolean[][] used = new boolean[row][column];

        int[][] move = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        used[startIndex0][startIndex1] = true;
        queue.offer(new int[]{startIndex0, startIndex1});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (chars[poll[0]][poll[1]] == 'E') {
                return true;
            }

            for (int[] ints : move) {
                int nextIndex0 = poll[0] + ints[0];
                int nextIndex1 = poll[1] + ints[1];
                if (0 <= nextIndex0 && nextIndex0 < row) {
                    if (0 <= nextIndex1 && nextIndex1 < column) {
                        if (chars[nextIndex0][nextIndex1] != '#') {
                            if (!used[nextIndex0][nextIndex1]) {
                                used[nextIndex0][nextIndex1] = true;
                                queue.offer(new int[]{nextIndex0, nextIndex1});
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
