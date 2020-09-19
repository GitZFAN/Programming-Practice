package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * @author fzhang
 * @date 2020-09-03
 */
public class Solution51 {
    public static int N;
    public static List<List<String>> lists;

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("total: " + lists.size());
    }

    /**
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     *
     * @param n 整数：皇后数量
     * @return 所有排列方案
     */
    public List<List<String>> solveNQueens(int n) {
        N = n;
        lists = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, path);

        return lists;
    }

    private void dfs(int level, LinkedList<Integer> path) {
        // 判断终止条件：path.size() == N 即，当前已经安排了 N 个 Queen。
        if (level == N) {
            ArrayList<String> strings = new ArrayList<>(N);
            // 输出 path
            for (Integer integer : path) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (i == integer) {
                        stringBuilder.append('Q');
                    } else {
                        stringBuilder.append('.');
                    }
                }
                strings.add(stringBuilder.toString());
            }
            lists.add(strings);
        }

        for (int i = 0; i < N; i++) {
            if (isPropertyLocation(level, i, path)) {
                path.offerLast(i);
                dfs(level + 1, path);
                path.pollLast();
            }
        }
    }

    /**
     * 判断在 (row, column) 位置摆放 Queen 是否合适
     *
     * @param row    行索引
     * @param column 列索引
     * @param path   已有的 Queen 的位置信息
     * @return 没有冲突，返回 true；否则，返回 false
     */
    private boolean isPropertyLocation(int row, int column, LinkedList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == column) {
                return false;
            }
            if ((i + path.get(i)) == (row + column)) {
                return false;
            }
            if ((path.get(i) - i) == (column - row)) {
                return false;
            }
        }
        return true;
    }
}