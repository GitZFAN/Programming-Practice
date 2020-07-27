package nowcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_JZ19 {

    int arrow = 0;

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        Solution_JZ19 solution_jz19 = new Solution_JZ19();
        ArrayList<Integer> integers = solution_jz19.printMatrix(matrix);
        System.out.println("integers = " + integers);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        int[][] status = new int[matrix.length][matrix[0].length];

        HashMap<Integer, Integer> hashMap = new HashMap<>(2);
        hashMap.put(0, 0);
        hashMap.put(1, 0);

        while (hashMap != null) {
            Integer first = hashMap.get(0);
            Integer second = hashMap.get(1);
            result.add(matrix[first][second]);
            hashMap = getNextIndex(status, hashMap);
        }

        return result;
    }

    private HashMap<Integer, Integer> getNextIndex(int[][] status, HashMap<Integer, Integer> index) {
        Integer first = index.get(0);
        Integer second = index.get(1);
        status[first][second] = 1;

        switch (arrow) {
            case 0:
                if (second + 1 < status[first].length && status[first][second + 1] == 0) {
                    index.put(0, first);
                    index.put(1, second + 1);
                } else {
                    arrow += 1;
                    if (first + 1 < status.length && status[first + 1][second] == 0) {
                        index.put(0, first + 1);
                        index.put(1, second);
                    } else {
                        index = null;
                    }
                }
                break;
            case 1:
                if (first + 1 < status.length && status[first + 1][second] == 0) {
                    index.put(0, first + 1);
                    index.put(1, second);
                } else {
                    arrow += 1;
                    if (second - 1 >= 0 && status[first][second - 1] == 0) {
                        index.put(0, first);
                        index.put(1, second - 1);
                    } else {
                        index = null;
                    }
                }
                break;
            case 2:
                if (second - 1 >= 0 && status[first][second - 1] == 0) {
                    index.put(0, first);
                    index.put(1, second - 1);
                } else {
                    arrow += 1;
                    if (first - 1 >= 0 && status[first - 1][second] == 0) {
                        index.put(0, first - 1);
                        index.put(1, second);
                    } else {
                        index = null;
                    }
                }
                break;
            case 3:
                if (first - 1 >= 0 && status[first - 1][second] == 0) {
                    index.put(0, first - 1);
                    index.put(1, second);
                } else {
                    arrow = 0;
                    if (second + 1 < status[first].length && status[first][second + 1] == 0) {
                        index.put(0, first);
                        index.put(1, second + 1);
                    } else {
                        index = null;
                    }
                }
                break;
            default:
        }

        return index;
    }
}
