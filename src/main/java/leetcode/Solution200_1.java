package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TheFan
 */
public class Solution200_1 {
    public static void main(String[] args) {
        Solution200_1 solution200 = new Solution200_1();
        /*char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };*/
        char[][] grid = {{
                '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'}, {
                '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'}, {
                '1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'}, {
                '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'}, {
                '1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {
                '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        int numIslands = solution200.numIslands(grid);
        System.out.println(numIslands);
    }

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    Queue<Pair<Integer, Integer>> neighbors = new LinkedList<>();
                    grid[i][j] = '2';
                    neighbors.add(new Pair<>(i, j));
                    while (!neighbors.isEmpty()) {
                        Pair<Integer, Integer> integerPair = neighbors.remove();
                        Integer key = integerPair.getKey();
                        Integer value = integerPair.getValue();
                        if (isValidLocaion(grid, key - 1, value)) {
                            if (grid[key - 1][value] == '1') {
                                grid[key - 1][value] = '2';
                                neighbors.add(new Pair<>(key - 1, value));
                            }
                        }
                        if (isValidLocaion(grid, key + 1, value)) {
                            if (grid[key + 1][value] == '1') {
                                grid[key + 1][value] = '2';
                                neighbors.add(new Pair<>(key + 1, value));
                            }
                        }
                        if (isValidLocaion(grid, key, value - 1)) {
                            if (grid[key][value - 1] == '1') {
                                grid[key][value - 1] = '2';
                                neighbors.add(new Pair<>(key, value - 1));
                            }
                        }
                        if (isValidLocaion(grid, key, value + 1)) {
                            if (grid[key][value + 1] == '1') {
                                grid[key][value + 1] = '2';
                                neighbors.add(new Pair<>(key, value + 1));
                            }
                        }
                    }
                    numOfIslands += 1;
                }
            }
        }
        return numOfIslands;
    }

    private boolean isValidLocaion(char[][] grid, int i, int j) {
        if (0 <= i && i < grid.length) {
            return 0 <= j && j < grid[i].length;
        }
        return false;
    }
}
