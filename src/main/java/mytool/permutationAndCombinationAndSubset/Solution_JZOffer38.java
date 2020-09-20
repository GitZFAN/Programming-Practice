package mytool.permutationAndCombinationAndSubset;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 剑指Offer 38：字符串全排列+去重
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution_JZOffer38 {

    char[] chars;
    LinkedList<String> result = new LinkedList<>();

    public static void main(String[] args) {
        Solution_JZOffer38 solution_jzOffer38 = new Solution_JZOffer38();
        String[] strings = solution_jzOffer38.permutation("abb");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public String[] permutation(String s) {
        chars = s.toCharArray();

        LinkedList<Integer> path = new LinkedList<>();
        dfs(path);

        return result.toArray(new String[0]);
    }

    /**
     * 不使用数组元素交换的回溯方法
     * <p>
     * 101 ms	44.1 MB
     *
     * @param path 回溯路径
     */
    private void dfs(LinkedList<Integer> path) {
        // 终止条件
        if (path.size() == chars.length) {
            // 输出路径
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : path) {
                stringBuilder.append(chars[integer]);
            }
            result.add(stringBuilder.toString());
        }

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!path.contains(i)) {
                if (!hashSet.contains(chars[i])) {
                    path.offerLast(i);
                    dfs(path);
                    path.pollLast();
                }
                hashSet.add(chars[i]);
            }
        }
    }

    /**
     * 通过数组元素交换的回溯方式实现排列
     * <p>
     * 14 ms	44.4 MB
     *
     * @param index 对 chars[] 中的剩余 [index, chars.length) 所有元素进行排列
     *              chars[] 中 [0, index) 部分已经排好，也即当前回溯的路径
     */
    private void permute(int index) {
        if (index == chars.length - 1) {
            // 增加一项排列方案
            result.add(String.valueOf(chars));
        }

        HashSet<Character> hashSet = new HashSet<>();
        // 对当前下标至末尾的所有数组元素进行排列
        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            if (!hashSet.contains(c)) {
                // 去除重复排列（因为数组中存在相同元素）
                hashSet.add(c);
                swap(index, i);
                permute(index + 1);
                swap(index, i);
            }
        }
    }

    /**
     * 交换chars中的两个元素
     * <p>
     * 通过 交换，实现 <b>记录已经访问的路径，并且划分 已访问 和 未访问 的元素集合</b>
     * 减少时间和空间代价
     *
     * @param index 前面元素的下标
     * @param i     后面元素的下标
     */
    private void swap(int index, int i) {
        char aChar = chars[index];
        chars[index] = chars[i];
        chars[i] = aChar;
    }

}
