package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 336. 回文对
 *
 * @author fzhang
 * @date 2020-08-06
 */
public class Solution336_1 {

    static class Node {
        int[] ch = new int[26];
        /**
         * 如果 falg != -1， 表示该 Node 是一个终止符。
         * 表示该 Node 之前所有 Node链 可以组成字符串，并且索引为 flag。
         */
        int flag;

        public Node() {
            flag = -1;
        }
    }

    /**
     * 字典树 数据结构，复用(从前往后最大)重复子串
     * 非常适合查找某个字符串在字符数组中的索引
     */
    List<Node> tree = new ArrayList<>();

    public static void main(String[] args) {
        String[] words = {"bat", "tab", "cat"};
        Solution336_1 solution336_1 = new Solution336_1();
        List<List<Integer>> lists = solution336_1.palindromePairs(words);
        for (List<Integer> integers : lists) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * 使用 <strong>字典树</strong> 存储所有字符串，
     * 在进行查询时，我们将待查询串的子串逆序地在字典树上进行遍历，即可判断其是否存在。
     *
     * @param words 一组 互不相同 的单词
     * @return 所有不同的可以拼接成回文串的索引对
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        // 将所有字符串存储到 字典树 中
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j <= len; j++) {
                // 将字符串 words[i] 分成两半：[0, j-1] 和 [j, len-1]
                if (isPalindrome(words[i], j, len - 1)) {
                    // 在字典树中查找 words[i]的子串[0, j-1] 对应的另一半字符串的索引
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        // 如果对应的另一半字符串存在
                        // 则 words[i]+words[leftId] 可以构成一整个回文字符串
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, len - 1);
                    if (rightId != -1 && rightId != i) {
                        // 则 words[rightId]+words[i] 可以构成一整个回文字符串
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 向字典树中插入指定字符串，并保存其在原始字符串数组中的索引
     *
     * @param s  需要插入的字符串
     * @param id 该字符串在所有字符串数组中的索引
     */
    public void insert(String s, int id) {
        int len = s.length();
        int add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    /**
     * 判断字符串 s 的子串 [s[left], s[right]] 是否是回文字符串
     *
     * @param s     原字符串
     * @param left  左边起始位置
     * @param right 右边终止位置
     * @return true:原字符串的指定子串是回文，否则，指定字串不是回文字符串
     */
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 在 字典树 中查找 s[left, right] 对应的 回文字符串 的索引
     *
     * @param s     查找源字符串
     * @param left  左边起始索引
     * @param right 右边终止索引
     * @return 对应目标字符串 s[right, left] 索引（如果不存在，则返回-1）
     */
    public int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }
}
