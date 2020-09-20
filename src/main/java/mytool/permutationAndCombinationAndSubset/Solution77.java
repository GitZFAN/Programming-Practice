package mytool.permutationAndCombinationAndSubset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 *
 * @author fzhang
 * @date 2020-09-08
 */
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();

        List<List<Integer>> combine = solution77.combine(4, 2);
        System.out.println("combine = " + combine);

        // DONE: 9/19/20 考虑k个数的排列呢？
        List<List<Integer>> permute = solution77.permute(4, 2);
        System.out.println("permute = " + permute);
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的排列
     *
     * @param n 表示 1 ... n 个可选项
     * @param k 从 n 中选出 k 个元素进行组合
     * @return k 个元素的排列结果
     */
    private List<List<Integer>> permute(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (k <= 0) {
            return result;
        }
        if (n < k) {
            return permute(n, n);
        }

        LinkedList<Integer> path = new LinkedList<>();
        permuteDfs(result, n, k, path);
        return result;
    }

    private void permuteDfs(LinkedList<List<Integer>> result, int n, int k, LinkedList<Integer> path) {
        if (path.size() == k) {
            ArrayList<Integer> list = new ArrayList<>(path);
            result.add(list);
        }

        for (int i = 1; i <= n; i++) {
            if (!path.contains(i)) {
                path.offerLast(i);
                permuteDfs(result, n, k, path);
                path.pollLast();
            }
        }

    }


    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
     * <p>
     * 回溯方法
     * <p>
     * 2 ms	40.1 MB
     *
     * @param n 表示 1 ... n 个可选项
     * @param k 从 n 中选出 k 个元素进行组合
     * @return k 个元素的组合结果
     */
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();

        dfs(result, n, 1, k, path);

        return result;
    }

    private void dfs(LinkedList<List<Integer>> result, int n, int startIndex, int k, LinkedList<Integer> path) {
        if (path.size() == k) {
            ArrayList<Integer> list = new ArrayList<>(path);
            result.add(list);
            return;
        }

        int remain = k - path.size();
        for (int i = startIndex; i + remain - 1 <= n; i++) {
            path.offerLast(i);
            dfs(result, n, i + 1, k, path);
            path.pollLast();
        }
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
     * <p>
     * 递归方法
     * <p>
     * 12 ms	46.5 MB
     *
     * @param n 表示 1 ... n 个可选项
     * @param k 从 n 中选出 k 个元素进行组合
     * @return k 个元素的组合结果
     */
    public List<List<Integer>> combine1(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (k < 1) {
            return null;
        }
        if (k > n) {
            return combine1(n, n);
        }

        return combineKFromIndex(n, 1, k);
    }

    private List<List<Integer>> combineKFromIndex(int n, int startIndex, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        // DONE: 9/8/20 这里 回溯+剪枝 的方法可以优化：
        //  1. 可以使用 栈 结构记录搜索路径
        //  2. 可以优化搜索终止的条件（DONE）

        // 有两种情况，递归都能终止
        if (k == 1) {
            // 第一种：剩下的所有元素中只需要取出1个元素进行组合
            for (int i = startIndex; i <= n; i++) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                result.add(list);
            }
            return result;
        }
        if (k == n - startIndex + 1) {
            // 第二种：需要取剩下的所有元素进行组合，那就只有一种结果
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = startIndex; i <= n; i++) {
                list.add(i);
            }
            result.add(list);
            return result;
        }

        // 开始递归
        for (int i = startIndex; i <= n - k + 1; i++) {
            List<List<Integer>> lists = combineKFromIndex(n, i + 1, k - 1);
            for (List<Integer> integers : lists) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                list.addAll(integers);
                result.add(list);
            }
        }

        return result;
    }
}
