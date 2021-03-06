package mytool.permutationAndCombinationAndSubset;

import java.util.*;

/**
 * 90. 子集 II
 *
 * @author fzhang
 * @date 2020-09-19
 */
public class Solution90 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 2};
        Solution90 solution90 = new Solution90();
        List<List<Integer>> lists = solution90.subsetsWithDup(ints);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个<b>可能包含重复元素</b>的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 必须对 nums[] 进行排序，实现数组中相同元素放在一起，然后通过变化 相同元素的个数 实现不同组合情况
     *
     * @param nums 一个<b>可能包含重复元素</b>的整数数组
     * @return 该数组所有可能的子集（幂集）
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // DONE: 9/19/20 为什么必须进行排序？因为组合不需要考虑元素的顺序
        // 目的：避免出现 {2, 5, 2} 的情况，即 相同的数字没有被排在一起。
        Arrays.sort(nums);

        LinkedList<Integer> path = new LinkedList<>();

        dfs(result, nums, 0, path);

        return result;
    }

    /**
     * 深度优先搜索
     *
     * @param result     记录所有子集的结果列表
     * @param nums       所有选择列表
     * @param startIndex 当前选择起始点，注意：这里结合已经排序的 nums 一起构成了组合的无序且不重复特性
     *                   因为 nums[0, startIndex) 区间的所有元素都被排除出搜索区间（剩余元素集合）
     * @param path       路径
     */
    private void dfs(LinkedList<List<Integer>> result, int[] nums, int startIndex, LinkedList<Integer> path) {
        // 因为本问题求的是树上的所有节点；
        // 所以，没有终止条件，即 startIndex 达到 nums.length 自然终止
        result.add(new ArrayList<>(path));

        // 去除重复选择的情况
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                path.offerLast(nums[i]);
                dfs(result, nums, i + 1, path);
                path.pollLast();
            }
            hashSet.add(nums[i]);
        }
    }
}
