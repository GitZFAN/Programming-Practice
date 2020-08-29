package leetcode;

import java.util.Arrays;

/**
 * 214. 最短回文串
 *
 * @author fzhang
 * @date 2020-08-29
 */
public class Solution214 {
    /**
     * TODO: 8/29/20 KMP 字符串匹配算法，copy from 题解，不是很理解
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);

        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

    /**
     * 结果超时：
     * 时间复杂度为 O(|s|^2)
     */
    public String shortestPalindrome1(String s) {
        int copyIndex = 1;

        // 寻找以 s 中第一个字符为 起始点 的最长回文子串
        int maxExtendIndex = (s.length() - 1) * 2;
        int extendIndex = maxExtendIndex / 2;
        for (; extendIndex > 0; extendIndex--) {
            // 判断以 extendIndex 为中心的回文字串能否扩展到 s 的首字符
            if (containFirst(s, extendIndex)) {
                break;
            }
        }

        if (extendIndex != 0) {
            copyIndex = extendIndex + 1;
        }

        // 从 s 末字符开始复制
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= copyIndex; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString() + s;
    }

    /**
     * 以 extendIndex 为中心的回文字串能否扩展到 s 的首字符
     *
     * @param s           原字符串
     * @param extendIndex 扩展中心
     * @return true：能够扩展到首字符，否则返回 false
     */
    private boolean containFirst(String s, int extendIndex) {
        int i;
        if (extendIndex % 2 == 0) {
            // 扩展中心为某字符
            i = 2;
        } else {
            // 扩展中心为俩字符中间
            i = 1;
        }
        for (; extendIndex - i >= 0; i += 2) {
            if (s.charAt((extendIndex - i) / 2) != s.charAt((extendIndex + i) / 2)) {
                break;
            }
        }
        return (extendIndex - i) < 0;
    }
}
