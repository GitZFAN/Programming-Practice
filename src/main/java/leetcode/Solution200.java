package leetcode;

public class Solution200 {

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int numIslands = solution200.numIslands(grid);
        System.out.println(numIslands);
    }

    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char e = grid[i][j];
                if (e == '1') {
                    traverseGrid(grid, i, j);
                    numOfIsland += 1;
                }
            }
        }
        return numOfIsland;
    }

    private void traverseGrid(char[][] grid, int i, int j) {
        if (isValidLocaion(grid, i, j)) {
            if (grid[i][j] == '1') {
                grid[i][j] = '2';
                traverseGrid(grid, i-1, j);
                traverseGrid(grid, i+1, j);
                traverseGrid(grid, i, j-1);
                traverseGrid(grid, i, j+1);
            }
        }
    }

    private boolean isValidLocaion(char[][] grid, int i, int j) {
        if (0 <= i && i < grid.length) {
            return 0 <= j && j < grid[i].length;
        }
        return false;
    }
}
