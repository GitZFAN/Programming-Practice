package jobsCodeExam2020.meituan;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution1 {
    public static void main(String[] args) {
        // 测试样例：
        // 8 3
        //1 0 1
        //0 1 0
        //0 1 0
        //1 0 1
        //1 0 1
        //0 1 0
        //0 1 0
        //1 0 1
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] ints = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            if (validReverse(ints, row, column, i)) {
                // System.out.println("valid " + i);
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k < column - 1; k++) {
                        System.out.print(ints[j][k] + " ");
                    }
                    System.out.println(ints[j][column - 1]);
                }
                break;
            }
        }
    }

    private static boolean validReverse(int[][] ints, int row, int column, int reverseEndLine) {
        if (row % (reverseEndLine + 1) != 0) {
            return false;
        }

        for (int i = 1; i < row / (reverseEndLine + 1); i++) {
            int validRow = i * (reverseEndLine + 1);
            if (i % 2 != 0) {
                // 逆向验证
                for (int j = reverseEndLine; j >= 0; j--) {
                    int line = reverseEndLine - j;
                    for (int k = 0; k < column; k++) {
                        if (ints[j][k] != ints[validRow + line][k]) {
                            return false;
                        }
                    }
                }
            } else {
                // 正常验证
                for (int j = 0; j <= reverseEndLine; j++) {
                    for (int k = 0; k < column; k++) {
                        if (ints[j][k] != ints[validRow + j][k]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
