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

    public String[] permutation(String s) {
        chars = s.toCharArray();

        permute(0);

        return result.toArray(new String[0]);
    }

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
