package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 316. 去除重复字母
 *
 * @author 13585
 * @date 2020-09-22
 */
public class Solution316 {
    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        String letters = solution316.removeDuplicateLetters("bcaacb");
        System.out.println("letters = " + letters);
    }

    /**
     * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * <p>
     * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     * @param s 带有重复字符的字符串
     * @return 去除重复字符的字典序最小新字符串
     */
    public String removeDuplicateLetters(String s) {
        // 单调（严格）递增栈
        LinkedList<Character> deque = new LinkedList<>();

        // 记录所有字符最后出现的索引
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (!deque.contains(charAt)) {
                while (!deque.isEmpty()) {
                    Character peekLast = deque.peekLast();
                    // 在保证不重复元素一定出现的前提下，栈组成的字符串字典序最小
                    if (peekLast > charAt && lastIndexMap.get(peekLast) > i) {
                        deque.pollLast();
                    } else {
                        break;
                    }
                }
                deque.offerLast(charAt);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : deque) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
