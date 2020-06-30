package nowcode;

import java.util.LinkedList;

public class Solution_JZ66 {

    public static void main(String[] args) {

    }

    public int movingCount(int threshold, int rows, int cols) {
        byte[][] matrix = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sumOfDigital(i) + sumOfDigital(j) > threshold) {
                    matrix[i][j] = -1;
                }
            }
        }

        move(matrix, 0, 0);


        /*
        广度搜索方法复杂度过大
        LinkedList<Integer> pointQueue = new LinkedList<>();
        pointQueue.add(0);
        pointQueue.add(0);

        while (!pointQueue.isEmpty()) {
            Integer firstIndex = pointQueue.poll();
            Integer secondIndex = pointQueue.poll();
            matrix[firstIndex][secondIndex] = 1;

            if ((secondIndex+1) < matrix[firstIndex].length) {
                byte right = matrix[firstIndex][secondIndex + 1];
                if (right == 0) {
                    pointQueue.add(firstIndex);
                    pointQueue.add(secondIndex+1);
                }
            }

            if ((firstIndex+1) < matrix.length) {
                byte down = matrix[firstIndex + 1][secondIndex];
                if (down == 0) {
                    pointQueue.add(firstIndex+1);
                    pointQueue.add(secondIndex);
                }
            }
        }*/

        int result = 0;

        for (byte[] rowArray : matrix) {
            for (byte point : rowArray) {
                if (point == 1) {
                    result += 1;
                }
            }
        }

        return result;
    }

    private void move(byte[][] matrix, int i, int j) {
        if (i < matrix.length && j < matrix[i].length) {
            if (matrix[i][j] == 0) {
                matrix[i][j] = 1;

                //move right
                move(matrix, i, j+1);
                //move down
                move(matrix, i+1, j);

            }
        }
    }

    private int sumOfDigital(int num) {
        int result = 0;
        while (num / 10 != 0) {
            result += num % 10;
            num /= 10;
        }
        result += num;
        return result;
    }
}
