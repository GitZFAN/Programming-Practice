package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 424. 替换后的最长重复字符
 *
 * @author fzhang
 * @date 2020-10-20
 */
public class Solution424 {
    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
     * 在执行上述操作后，找到包含重复字母的最长子串的长度。
     * <p>
     * 思路：滑动窗口
     * <p>
     * 关于maxCount的解释（感谢评论下方的小伙伴）：
     * 因为我们只对最长有效的子字符串感兴趣，所以我们的滑动窗口不需要收缩，即使窗口可能覆盖无效的子字符串。
     * 我们可以通过在右边添加一个字符来扩展窗口，或者将整个窗口向右边移动一个字符。
     * 而且我们只在新字符的计数超过历史最大计数(来自覆盖有效子字符串的前一个窗口)时才增长窗口。
     * 也就是说，我们不需要精确的当前窗口的最大计数;我们只关心最大计数是否超过历史最大计数;这只会因为新字符而发生。
     *
     * @param s 一个仅由大写英文字母组成的字符串
     * @param k 最多可替换次数
     * @return 在执行替换操作后，找到包含重复字母的最长子串的长度。
     */
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int historyCharMaxCount = 0;
        for (int right = 0; right < chars.length; right++) {
            Integer num;
            if (hashMap.containsKey(chars[right])) {
                num = hashMap.get(chars[right]);
                num += 1;
            } else {
                num = 1;
            }
            hashMap.put(chars[right], num);

            if (num > historyCharMaxCount) {
                historyCharMaxCount = num;
            }

            if ((right - left + 1) > (historyCharMaxCount + k)) {
                hashMap.put(chars[left], hashMap.get(chars[left]) - 1);
                left += 1;
            }
        }

        return chars.length - left;
    }

    /**
     * 思路：{@link Solution1004#longestOnes(int[], int)}
     * 结果：
     * 31 ms	37.7 MB
     * 时间消耗过大
     *
     * @param s 一个仅由大写英文字母组成的字符串
     * @param k 最多可替换次数
     * @return 在执行替换操作后，找到包含重复字母的最长子串的长度。
     */
    public int characterReplacement1(String s, int k) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            if (!hashMap.containsKey(aChar)) {
                hashMap.put(aChar, 1);
            } else {
                Integer num = hashMap.get(aChar);
                num += 1;
                hashMap.put(aChar, num);
            }
        }

        int maxLength = 0;
        ArrayList<Map.Entry<Character, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        arrayList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Character, Integer> characterIntegerEntry : arrayList) {
            if ((characterIntegerEntry.getValue() + k) > maxLength) {
                // 理论上有可能超过最大长度
                int length = 0;
                int left = -1;
                int numOf0 = 0;
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] != characterIntegerEntry.getKey()) {
                        numOf0 += 1;
                    }
                    if (numOf0 > k) {
                        while (left < j) {
                            left += 1;
                            if (chars[left] != characterIntegerEntry.getKey()) {
                                break;
                            }
                        }
                        numOf0 -= 1;
                    }
                    length = Math.max(length, j - left);
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
