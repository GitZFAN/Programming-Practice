package jobsCodeExam2020.xiaomi;

import leetcode.Solution79;

import java.util.Scanner;

/**
 * 见 leetcode <i>79. 单词搜索</i>
 *
 * @author 13585
 * @date 2020-09-08
 * @see Solution79
 */
public class Solution2 {
    static char[][] chars;
    static boolean[][] used;

    static int row;
    static int column;
    static int[][] move;

    public static void main(String[] args) {
        chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        used = new boolean[3][4];

        row = chars.length;
        column = chars[0].length;

        // 移动方向（顺时针变化：→ ↓ ← ↑）
        move = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            System.out.println(isExist(word));
        }
    }

    private static boolean isExist(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                // 遍历矩阵的中所有元素作为匹配的开端，只要其中有一个满足要求即可
                if (dfs(word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 矩阵 深度优先 搜索
     *
     * @param word   匹配的元素集合
     * @param index0 矩阵第一维下标
     * @param index1 矩阵第二维下标
     * @param start  集合开始匹配下标
     * @return 是否存在完全匹配
     */
    private static boolean dfs(String word, int index0, int index1, int start) {
        if (start == word.length() - 1) {
            return chars[index0][index1] == word.charAt(start);
        }
        if (word.charAt(start) == chars[index0][index1]) {
            used[index0][index1] = true;
            for (int[] ints : move) {
                int nextIndex0 = index0 + ints[0];
                int nextIndex1 = index1 + ints[1];
                if (0 <= nextIndex0 && nextIndex0 < row) {
                    if (0 <= nextIndex1 && nextIndex1 < column) {
                        if (!used[nextIndex0][nextIndex1]) {
                            if (dfs(word, nextIndex0, nextIndex1, start + 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
            used[index0][index1] = false;
        }
        return false;
    }
}
