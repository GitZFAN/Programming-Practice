package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 130. 被围绕的区域
 *
 * @author fzhang
 * @date 2020-08-11
 */
public class Solution130 {
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }

        Deque<int[]> queue = new LinkedList<>();

        // 遍历 board[] 所有的边界，找到边界上所有值为 ‘O’ 的元素
        // 先遍历左右边界
        for (int i = 0; i < board.length; i++) {
            char left = board[i][0];
            if (left == 'O') {
                board[i][0] = 'Y';
                queue.offer(new int[]{i, 0});
            }

            int lastColumn = board[i].length - 1;
            char right = board[i][lastColumn];
            if (right == 'O') {
                board[i][lastColumn] = 'Y';
                queue.offer(new int[]{i, lastColumn});
            }
        }
        // 然后遍历上下边界
        for (int i = 0; i < board[0].length; i++) {
            char up = board[0][i];
            if (up == 'O') {
                board[0][i] = 'Y';
                queue.offer(new int[]{0, i});
            }

            int lastRow = board.length - 1;
            char down = board[lastRow][i];
            if (down == 'O') {
                board[lastRow][i] = 'Y';
                queue.offer(new int[]{lastRow, i});
            }
        }

        // 取出队列中的元素，并进行逐个处理
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            // 扩展相连元素
            extendElement(board, queue, index);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 扩展与某元素相连的所有合格元素
     *
     * @param board 原字符矩阵
     * @param queue 合格元素存储队列
     * @param index 取出元素索引
     */
    private void extendElement(char[][] board, Deque<int[]> queue, int[] index) {
        // up
        if (index[0] - 1 >= 0 && board[index[0] - 1][index[1]] == 'O') {
            board[index[0] - 1][index[1]] = 'Y';
            queue.offer(new int[]{index[0] - 1, index[1]});
        }

        // down
        if (index[0] + 1 < board.length && board[index[0] + 1][index[1]] == 'O') {
            board[index[0] + 1][index[1]] = 'Y';
            queue.offer(new int[]{index[0] + 1, index[1]});
        }

        // left
        if (index[1] - 1 >= 0 && board[index[0]][index[1] - 1] == 'O') {
            board[index[0]][index[1] - 1] = 'Y';
            queue.offer(new int[]{index[0], index[1] - 1});
        }

        // right
        if (index[1] + 1 < board[0].length && board[index[0]][index[1] + 1] == 'O') {
            board[index[0]][index[1] + 1] = 'Y';
            queue.offer(new int[]{index[0], index[1] + 1});
        }

    }
}
