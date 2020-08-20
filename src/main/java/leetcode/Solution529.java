package leetcode;

/**
 * 529. 扫雷游戏
 *
 * @author fzhang
 * @date 2020-08-20
 */
public class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        // 判断 click 的位置是否合理（位置合法，且该位置未被挖出）
        if (!isLegalLocation(board, click[0], click[1])) {
            return null;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            // 判断该位置周围相邻地雷数量
            int mine = numOfMine(board, click[0], click[1]);
            if (mine != 0) {
                board[click[0]][click[1]] = (char) ('0' + mine);
            } else {
                board[click[0]][click[1]] = 'B';
                // 所有和其相邻的未挖出方块都应该被递归地揭露
                int[] ints0 = {-1, -1, 0, 1, 1, 1, 0, -1};
                int[] ints1 = {0, 1, 1, 1, 0, -1, -1, -1};

                for (int i = 0; i < ints0.length; i++) {
                    int first = click[0] + ints0[i];
                    int second = click[1] + ints1[i];
                    if (isLegalLocation(board, first, second)) {
                        if (board[first][second] == 'E') {
                            updateBoard(board, new int[]{first, second});
                        }
                    }
                }
            }
        }
        return board;
    }

    private int numOfMine(char[][] board, int index0, int index1) {
        int result = 0;
        int[] ints0 = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] ints1 = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < ints0.length; i++) {
            int first = index0 + ints0[i];
            int second = index1 + ints1[i];
            if (isLegalLocation(board, first, second)) {
                if (board[first][second] == 'M') {
                    result += 1;
                }
            }
        }
        return result;
    }

    private boolean isLegalLocation(char[][] board, int index0, int index1) {
        if (0 <= index0 && index0 < board.length) {
            return 0 <= index1 && index1 < board[index0].length;
        }
        return false;
    }

}
