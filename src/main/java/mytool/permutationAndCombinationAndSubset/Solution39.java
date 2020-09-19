package mytool.permutationAndCombinationAndSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author fzhang
 * @date 2020-09-09
 */
public class Solution39 {
    List<List<Integer>> result;

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * <b>candidates 中的数字可以无限制重复被选取。</b>
     *
     * @param candidates 无重复元素的数组
     * @param target     目标数
     * @return candidates 中所有可以使数字和为 target 的组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();

        // 对 candidates 进行排序是为了 剪枝
        // 排序是 剪枝 的前提
        Arrays.sort(candidates);

        dfs(candidates, 0, target, path);

        return result;
    }

    /**
     * 回溯算法，相当于 DFS，回溯法通过剪枝来减少选择次数
     *
     * @param ints       候选数组
     * @param startIndex 搜索起点
     * @param target     目标值（每减去一个元素，目标值变小）
     * @param path       从根结点到叶子结点的路径（是一个栈）
     * @see #result 组合结果集合
     */
    private void dfs(final int[] ints, int startIndex, int target, LinkedList<Integer> path) {
        if (target == 0) {
            if (path.size() != 0) {
                // 注意：这里需要将 path 内的所有元素拷贝到新 list
                // 不然，后面的回溯操作会影响 path 中的内容
                ArrayList<Integer> list = new ArrayList<>(path);
                result.add(list);
            }
            return;
        }

        for (int i = startIndex; i < ints.length; i++) {
            if (ints[i] <= target) {
                path.add(ints[i]);
                dfs(ints, i, target - ints[i], path);
                path.removeLast();
            } else {
                break;
            }
        }
    }
}
