package leetcode;

/**
 * 696. 计数二进制子串
 *
 * @author fzhang
 * @date 2020-08-10
 */
public class Solution696 {
    public int countBinarySubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char pre = s.charAt(i);
            char post = s.charAt(i + 1);
            if (pre != post) {
                result += countSubstrings(s, i, i + 1);
            }
        }
        return result;
    }

    private int countSubstrings(String s, int pre, int post) {
        int result = 1;
        for (int i = 1; pre - i >= 0 && post + i < s.length(); i++) {
            char c = s.charAt(pre - i);
            char c1 = s.charAt(post + i);
            if (c == s.charAt(pre) && c1 == s.charAt(post)) {
                result += 1;
            } else {
                break;
            }
        }
        return result;
    }
}
