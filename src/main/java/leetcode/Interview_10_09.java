package leetcode;

/**
 * 面试题 10.09. 排序矩阵查找
 *
 * @author fzhang
 * @date 2020-10-21
 */
public class Interview_10_09 {
    /**
     * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
     *
     * @param matrix 每一行、每一列都按升序排列的 M×N矩阵
     * @param target 目标元素
     * @return 元素在矩阵中是否存在
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int index0 = row - 1;
        int index1 = 0;

        while (index0 >= 0 && index1 < column) {
            if (matrix[index0][index1] == target) {
                return true;
            } else if (matrix[index0][index1] > target) {
                index0 -= 1;
            } else if (matrix[index0][index1] < target) {
                index1 += 1;
            }
        }

        return false;
    }
}
