package nowcode.weipinhui;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 查找无重复字符的最长子串
 * <p>
 * 可参考滑动窗口的设计思想
 *
 * @author 13585
 * @date 2020-09-18
 * @see leetcode.Solution_JZOffer48 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // 双端队列：表示滑动窗口
        Deque<Character> deque = new LinkedList<>();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
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
        System.out.println(maxLength);
    }
}
