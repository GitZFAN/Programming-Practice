package nowcode.bilibili;

import leetcode.Solution54;

import java.util.Arrays;

/**
 * 见 leetcode <i>54. 螺旋矩阵</i>
 *
 * @author 13585
 * @date 2020-09-04
 * @see Solution54
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution2 solution2 = new Solution2();
        int[] spiralMatrix = solution2.SpiralMatrix(ints);
        System.out.println("spiralMatrix = " + Arrays.toString(spiralMatrix));
    }

    public int[] SpiralMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        int[] result = new int[row * column];
        int[][] status = new int[row][column];

        int index0 = 0;
        int index1 = 0;
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[index0][index1];
            status[index0][index1] = 1;
            int nextIndex0 = index0 + move[direction][0];
            int nextIndex1 = index1 + move[direction][1];
            if (nextIndex0 < 0 || nextIndex0 >= row || nextIndex1 < 0 || nextIndex1 >= column || status[nextIndex0][nextIndex1] != 0) {
                direction = (direction + 1) % 4;
            }
            index0 += move[direction][0];
            index1 += move[direction][1];
        }

        return result;
    }
}
