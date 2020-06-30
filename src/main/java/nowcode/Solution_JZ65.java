package nowcode;

import java.util.Arrays;

public class Solution_JZ65 {
    public static void main(String[] args) {
        char[] matrix = {'A', 'B', 'C', 'E',
                'S', 'F', 'C', 'S',
                'A', 'D', 'E', 'E'};
        char[] str = {'A', 'B', 'C', 'C', 'E', 'D'};

        Solution_JZ65 solution_jz65 = new Solution_JZ65();
        System.out.println(solution_jz65.hasPath(matrix, 3, 4, str));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] chars = new char[rows][cols];
        byte[][] isVisit = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (cols >= 0) {
                System.arraycopy(matrix, i * cols, chars[i], 0, cols);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                char mchar = chars[i][j];
                if (mchar == str[0]) {
                    isVisit[i][j] = 1;
                    boolean isFind = findPath(chars, i, j, isVisit, str, 0);
                    if (isFind) {
                        return true;
                    } else {
                        for (int k = 0; k < isVisit.length; k++) {
                            Arrays.fill(isVisit[k], (byte) 0);
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean findPath(char[][] chars, int i, int j, byte[][] isVisit, char[] str, int findedIndex) {
        if (findedIndex == str.length - 1) {
            return true;
        }
        // look up
        if (i - 1 >= 0) {
            if (isVisit[i - 1][j] == 0) {
                if (chars[i - 1][j] == str[findedIndex + 1]) {
                    isVisit[i - 1][j] = 1;
                    boolean isFound = findPath(chars, i - 1, j, isVisit, str, findedIndex + 1);
                    if (isFound) {
                        return true;
                    } else {
                        isVisit[i - 1][j] = 0;
                    }
                }
            }
        }

        // look down
        if (i + 1 < chars.length) {
            if (isVisit[i + 1][j] == 0) {
                if (chars[i + 1][j] == str[findedIndex + 1]) {
                    isVisit[i + 1][j] = 1;
                    boolean isFound = findPath(chars, i + 1, j, isVisit, str, findedIndex + 1);
                    if (isFound) {
                        return true;
                    } else {
                        isVisit[i + 1][j] = 0;
                    }
                }
            }
        }

        // look left
        if (j - 1 >= 0) {
            if (isVisit[i][j - 1] == 0) {
                if (chars[i][j - 1] == str[findedIndex + 1]) {
                    isVisit[i][j - 1] = 1;
                    boolean isFound = findPath(chars, i, j - 1, isVisit, str, findedIndex + 1);
                    if (isFound) {
                        return true;
                    } else {
                        isVisit[i][j - 1] = 0;
                    }
                }
            }
        }

        // look right
        if (j + 1 < chars[i].length) {
            if (isVisit[i][j + 1] == 0) {
                if (chars[i][j + 1] == str[findedIndex + 1]) {
                    isVisit[i][j + 1] = 1;
                    boolean isFound = findPath(chars, i, j + 1, isVisit, str, findedIndex + 1);
                    if (isFound) {
                        return true;
                    } else {
                        isVisit[i][j + 1] = 0;
                    }
                }
            }
        }

        return false;
    }
}
