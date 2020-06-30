package leetcode;

public class Solution_221 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Solution_221 solution_221 = new Solution_221();
        int maximalSquare = solution_221.maximalSquare(matrix);
        System.out.println(maximalSquare);
    }

    public int maximalSquare(char[][] matrix) {
        int maxEdgeLength= 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int edgeLength = maxEdgeLength(matrix, i, j);
                    if (edgeLength > maxEdgeLength) {
                        maxEdgeLength = edgeLength;
                    }
                }
            }
        }

        return maxEdgeLength*maxEdgeLength;
    }

    private int maxEdgeLength(char[][] matrix, int i, int j) {
        int maxEdge = 1;
        boolean flag = true;
        while (flag) {
            int edgeStep = maxEdge;
            //判断是否越界
            if (j+edgeStep < matrix[i].length && i+edgeStep < matrix.length) {
                //判断右侧能否扩展
                for (int k = 0; k <= edgeStep; k++) {
                    if (matrix[i+k][j+edgeStep] != '1') {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                //判断下侧能否扩展
                for (int k = 0; k <= edgeStep; k++) {
                    if (matrix[i+edgeStep][j+k] != '1') {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                maxEdge += 1;
            } else {
                break;
            }
        }
        return maxEdge;
    }

}
