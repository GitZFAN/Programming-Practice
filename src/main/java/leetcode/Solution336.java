package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 336. 回文对
 *
 * @author fzhang
 * @date 2020-08-06
 */
public class Solution336 {

    String[] strings;

    /**
     * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，
     * 使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     *
     * @param words 一组 互不相同 的单词
     * @return 所有不同的索引对
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        this.strings = words;
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                List<List<Integer>> palindromeList = palindromeList(i, j);
                if (palindromeList.size() != 0) {
                    result.addAll(palindromeList);
                }
            }
        }
        return result;
    }

    /**
     * 遍历所有可能组合，判断每种组合是否产生回文字符串
     * <p>
     * 时间复杂度 O(n^2)，会超时
     *
     * @param index1 第一个元素下标
     * @param index2 第二个元素下标
     * @return 如果能构成回文，则返回下标List，否则返回空List
     */
    private List<List<Integer>> palindromeList(int index1, int index2) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> pairs = new ArrayList<>(2);

        String word1 = strings[index1];
        String word2 = strings[index2];

        if (isPalindrome(word1, word2)) {
            pairs.add(index1);
            pairs.add(index2);
            results.add(pairs);
            pairs = new ArrayList<>(2);
        }

        if (isPalindrome(word2, word1)) {
            pairs.add(index2);
            pairs.add(index1);
            results.add(pairs);
        }

        return results;
    }

    private boolean isPalindrome(String word1, String word2) {
        String s = word1 + word2;
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverseString = stringBuilder.reverse().toString();
        return s.equals(reverseString);
    }
}
