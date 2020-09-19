package mytool.permutationAndCombinationAndSubset;


import java.util.*;

/**
 * 40. 组合总和 II
 *
 * @author fzhang
 * @date 2020-09-10
 */
public class Solution40 {
    int[] ints;
    List<List<Integer>> result;

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <b>所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     *
     * @param candidates 具有重复元素的数组
     * @param target     目标数
     * @return candidates 中所有可以使数字和为 target 的组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        ints = candidates;

        // DONE: 9/19/20 为什么必须进行排序？因为组合不需要考虑元素的顺序
        // 目的：避免出现 {2, 5, 2} 的情况，即 相同的数字没有被排在一起。
        Arrays.sort(candidates);

        LinkedList<Integer> path = new LinkedList<>();

        dfs(0, target, path);

        return result;
    }

    /**
     * 回溯算法，相当于 DFS，回溯法通过剪枝来减少选择次数
     *
     * @param startIndex 搜索起点
     * @param target     目标数
     * @param path       从根结点到叶子结点的路径（是一个栈）
     * @see #ints 候选数组
     * @see #result 组合结果集合
     */
    private void dfs(int startIndex, int target, LinkedList<Integer> path) {
        if (target == 0) {
            if (path.size() != 0) {
                ArrayList<Integer> list = new ArrayList<>(path);
                result.add(list);
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < ints.length; i++) {
            if (ints[i] <= target) {
                if (!hashSet.contains(ints[i])) {
                    hashSet.add(ints[i]);

                    path.push(ints[i]);

                    int minValue = Integer.MIN_VALUE;

                    // 注意，这里下一次递归的 起点 应该是下一个与 startIndex 上数字不同的元素
                    // 需要避免掉重复的情况
                    dfs(i + 1, target - ints[i], path);

                    path.pop();
                }
            } else {
                break;
            }
        }

    }
}
