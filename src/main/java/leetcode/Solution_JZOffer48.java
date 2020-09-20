package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 可参考滑动窗口的设计思想
 *
 * @author 13585
 * @date 2020-09-20
 */
public class Solution_JZOffer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 双端队列：表示滑动窗口
        Deque<Character> deque = new LinkedList<>();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (deque.contains(charAt)) {
                // 窗口中包括该字符
                while (!deque.isEmpty()) {
                    // 移除窗口中该字符及之前的所有字符
                    if (deque.peekFirst().equals(charAt)) {
                        deque.pollFirst();
                        break;
                    } else {
                        deque.pollFirst();
                    }
                }

            }
            deque.offerLast(charAt);
            maxLength = Math.max(maxLength, deque.size());
        }
        return maxLength;
    }
}
