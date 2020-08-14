package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 *
 * @author fzhang
 * @date 2020-08-14
 */
public class Solution20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                // 左括号
                stack.push(c);
            } else {
                // 右括号
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (hashMap.get(pop) != c) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
