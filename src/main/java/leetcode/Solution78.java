package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author fzhang
 * @date 2020-09-19
 */
public class Solution78 {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
     * 注：解集不能包含重复的子集。
     * <p>
     * 回溯法
     *
     * @param nums <b>不含重复元素</b> 的整数数组
     * @return 该数组所有可能的子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 这里排序的目的：按字典序输出
        Arrays.sort(nums);

        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        dfs(result, nums, 0, path);

        return result;
    }

    /**
     * 前序遍历
     *
     * @param result     结果列表
     * @param nums       所有选择列表
     * @param startIndex 当前选择起始点
     * @param path       路径
     */
    private void dfs(LinkedList<List<Integer>> result, int[] nums, int startIndex, LinkedList<Integer> path) {
        // 因为本问题求的是树上的所有节点；
        // 所以，没有终止条件，即 startIndex 达到 nums.length 自然终止
        ArrayList<Integer> list = new ArrayList<>(path);
        result.add(list);

        for (int i = startIndex; i < nums.length; i++) {
            path.offerLast(nums[i]);
            dfs(result, nums, i + 1, path);
            path.pollLast();
        }
    }

    /**
     * 递归方法（迭代实现）：从前往后递推
     *
     * @param nums 不含重复元素的整数数组
     * @return 该数组所有可能的子集
     */
    public List<List<Integer>> subsets1(int[] nums) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        lists.add(new ArrayList<>());

        Arrays.sort(nums);

        for (int num : nums) {
            LinkedList<List<Integer>> linkedList = new LinkedList<>();
            for (List<Integer> list : lists) {
                ArrayList<Integer> list1 = new ArrayList<>(list);
                list1.add(num);
                linkedList.add(list1);
            }

            lists.addAll(linkedList);
        }

        return lists;
    }

    /**
     * 递归方法（递归实现）：从后往前倒推
     * <p>
     * 并不推荐，因为这里没有优势，完全可以使用迭代替代，反而增加了额外的栈的使用代价
     *
     * @param nums 不含重复元素的整数数组
     * @return 该数组所有可能的子集
     */
    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        return getSubSet(nums, nums.length - 1);
    }

    private List<List<Integer>> getSubSet(int[] nums, int startIndex) {
        if (startIndex == -1) {
            LinkedList<List<Integer>> lists = new LinkedList<>();
            lists.add(new ArrayList<>());
            return lists;
        }

        List<List<Integer>> lists = getSubSet(nums, startIndex - 1);

        int size = lists.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = lists.get(i);
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(nums[startIndex]);
            lists.add(list1);
        }

        return lists;
    }

    /**
     * 二进制排序 子集
     * <p>
     * 将每个子集映射到长度为 n 的位掩码中，
     * 其中第 i 位掩码 nums[i] 为 1，表示第 i 个元素在子集中；
     * 如果第 i 位掩码 nums[i] 为 0，表示第 i 个元素不在子集中。
     * <p>
     * 生成所有子集，只需要生成从 0..00 到 1..11 的所有 n 位掩码，一共有 2^n 个组合。
     *
     * @param nums <b>不含重复元素</b> 的整数数组
     * @return 该数组所有可能的子集
     */
    public List<List<Integer>> subsets3(int[] nums) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        // 需要生成 n 位的掩码
        int n = nums.length;

        int nthBit = 1 << n;
        for (int i = 0; i < Math.pow(2, n); i++) {
            int comValue = nthBit | i;
            // 去除开头的 1，得到的就是某一种组合
            String combination = Integer.toBinaryString(comValue).substring(1);

            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < combination.length(); j++) {
                char charAt = combination.charAt(j);
                if (charAt == '1') {
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }


        return lists;
    }
}
