package leetcode;

public class Solution_m13 {
    public int movingCount(int m, int n, int k) {
        int[][] box = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = sumOfNum(i) + sumOfNum(j);
                if (sum <= k) {
                    box[i][j] = 1;
                }
            }
        }

        move(box, 0, 0);

        int count = 0;

        for (int[] line :
                box) {
            for (int colum :
                    line) {
                if (colum == 2) {
                    count++;
                }
            }
        }

        return count;
    }

    private void move(int[][] box, int i, int j) {
        //判断当前位置是否可行
        if (isValidLocation(box, i, j)) {
            box[i][j] = 2;
        } else {
            return;
        }
        //往上走
        if (isValidLocation(box, i-1, j)) {
            move(box, i-1, j);
        }
        //往下走
        if (isValidLocation(box, i+1, j)) {
            move(box, i+1, j);
        }
        if (isValidLocation(box, i, j-1)) {
            move(box, i, j-1);
        }
        if (isValidLocation(box, i, j+1)) {
            move(box, i, j+1);
        }
    }

    private boolean isValidLocation(int[][] box, int i, int j) {
        if (0 <= i && i < box.length) {
            if (0 <= j && j < box[0].length) {
                return box[i][j] == 1;
            }
        }
        return false;
    }

    private int sumOfNum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i%10;
            i /= 10;
        }
        return sum;
    }


}
