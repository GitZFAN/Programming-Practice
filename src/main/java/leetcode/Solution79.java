package leetcode;

/**
 * 79. 单词搜索
 * <p>给定一个二维网格和一个单词，找出该单词是否存在于网格中。</p>
 *
 * @author fzhang
 * @date 2020-09-08
 */
public class Solution79 {

    int row;
    int column;
    boolean[][] used;

    /**
     * 移动方向（顺时针变化：→ ↓ ← ↑）
     */
    final int[][] move = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean exist = solution79.exist(board, "ESCEDFBCE");
        System.out.println("exist = " + exist);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        row = board.length;
        column = board[0].length;
        used = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int index0, int index1, String word, int start) {
        if (start == word.length() - 1) {
            return board[index0][index1] == word.charAt(start);
        }
        if (board[index0][index1] == word.charAt(start)) {
            used[index0][index1] = true;
            for (int[] ints : move) {
                int nextIndex0 = index0 + ints[0];
                int nextIndex1 = index1 + ints[1];
                if ((0 <= nextIndex0 && nextIndex0 < row)) {
                    if (0 <= nextIndex1 && nextIndex1 < column) {
                        if (!used[nextIndex0][nextIndex1]) {
                            if (dfs(board, nextIndex0, nextIndex1, word, start + 1)) {
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
