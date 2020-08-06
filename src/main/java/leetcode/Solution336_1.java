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
        int flag;

        public Node() {
            flag = -1;
        }
    }

    /**
     * 字典树 数据结构，复用(从前往后最大)重复子串
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
     * 使用 <strong>字典树</strong> 存储所有字符串，在进行查询时，我们将待查询串的子串逆序地在字典树上进行遍历，即可判断其是否存在。
     *
     * @param words 所有的字符
     * @return 所有不同的可以拼接成回文串的索引对
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
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

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

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
