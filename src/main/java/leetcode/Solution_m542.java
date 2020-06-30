package leetcode;

public class Solution_m542 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 0, 1}
        };

        Solution_m542 solutionM542 = new Solution_m542();
        int[][] updateMatrix = solutionM542.updateMatrix(matrix);
        for (int[] ints : updateMatrix) {
            for (int j = 0; j < updateMatrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        // 初始化矩阵，用带-号的表示所有未访问到的元素
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= -1;
            }
        }

        boolean isUpdated = true;
        int var = 0;
        while (isUpdated) {
            isUpdated = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    // 找到矩阵中值等于当前迭代变量var的元素
                    if (matrix[i][j] == var) {
                        // 根据该元素的值更新它的邻居元素
                        updateNeibor(matrix, i, j);
                        isUpdated = true;
                    }
                }
            }
            var += 1;
        }
        return matrix;
    }


    private void updateNeibor(int[][] matrix, int i, int j) {
        // 更新上邻居
        if ( isValid(matrix, i-1, j) ) {
            if (matrix[i-1][j] < 0) {
                matrix[i-1][j] = matrix[i][j] + 1;
            }
        }
        // 更新左邻居
        if ( isValid(matrix, i, j-1) ) {
            if (matrix[i][j-1] < 0) {
                matrix[i][j-1] = matrix[i][j] + 1;
            }
        }
        // 更新下邻居
        if ( isValid(matrix, i+1, j) ) {
            if (matrix[i+1][j] < 0) {
                matrix[i+1][j] = matrix[i][j] + 1;
            }
        }
        // 更新右邻居
        if ( isValid(matrix, i, j+1) ) {
            if (matrix[i][j+1] < 0) {
                matrix[i][j+1] = matrix[i][j] + 1;
            }
        }
    }

    /**
     * 判断matrix[i][j]是否为matric中有效元素
     * @param matrix 矩阵
     * @param i 行坐标
     * @param j 纵坐标
     * @return true 有效；false 无效
     */
    private boolean isValid(int[][] matrix, int i, int j) {
        if (0 <= i && i < matrix.length) {
            if (0 <= j && j < matrix[0].length) {
                return true;
            }
        }
        return false;
    }
}
