package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author fzhang
 * @date 2020-09-04
 */
public class Solution54 {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] ints1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Solution54 solution54 = new Solution54();
        List<Integer> list = solution54.spiralOrder(ints1);
        System.out.println("list = " + list);
    }

    /**
     * 按照顺时针螺旋顺序，返回矩阵中的所有元素
     *
     * @param matrix 需要输出的矩阵
     * @return 矩阵按顺时针顺序输出得到的元素列表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        int rIndex = 0;
        int cIndex = 0;

        // 右 下 左 上
        int[][] move = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        // 初始方向
        int direction = 0;

        List<Integer> result = new ArrayList<>(rows * columns);

        while (true) {
            visited[rIndex][cIndex] = true;
            result.add(matrix[rIndex][cIndex]);

            // 访问下一个位置
            int rNext = rIndex + move[direction][0];
            int cNext = cIndex + move[direction][1];

            if (rNext < 0 || rNext >= rows || cNext < 0 || cNext >= columns || visited[rNext][cNext]) {
                // 调整方向
                direction = (direction + 1) % 4;
                rNext = rIndex + move[direction][0];
                cNext = cIndex + move[direction][1];
                if (rNext < 0 || rNext >= rows || cNext < 0 || cNext >= columns || visited[rNext][cNext]) {
                    // 如果调整完后发现 依旧 不行，则访问结束
                    break;
                }
            }
            rIndex = rNext;
            cIndex = cNext;
        }

        return result;
    }
}
