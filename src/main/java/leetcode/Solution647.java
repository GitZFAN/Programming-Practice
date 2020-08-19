package leetcode;

/**
 * 647. 回文子串
 *
 * @author fzhang
 * @date 2020-08-19
 */
public class Solution647 {

    String globalString;

    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        int countSubstrings = solution647.countSubstrings("aaaaa");
        System.out.println("countSubstrings = " + countSubstrings);
    }

    public int countSubstrings(String s) {
        globalString = s;
        int count = 0;
        if (s == null || s.length() == 0) {
            return count;
        }

        for (int i = 0; i < s.length() * 2 - 1; i++) {
            if (i % 2 == 0) {
                // 以 s 中某个字符为中心向两边扩展
                count += singlePalindromeCount(i / 2);
            } else {
                // 以 s 中某俩相同字符为中心向两边扩展
                count += doublePalindromeCount((i - 1) / 2, (i + 1) / 2);
            }
        }

        return count;
    }

    private int doublePalindromeCount(int pre, int post) {
        if (globalString.charAt(pre) != globalString.charAt(post)) {
            return 0;
        }

        int result = 1;
        for (int i = 1; pre - i >= 0 && post + i < globalString.length(); i++) {
            if (globalString.charAt(pre - i) == globalString.charAt(post + i)) {
                result += 1;
            } else {
                break;
            }
        }
        return result;
    }

    private int singlePalindromeCount(int index) {
        int result = 1;
        for (int i = 1; index - i >= 0 && index + i < globalString.length(); i++) {
            if (globalString.charAt(index - i) == globalString.charAt(index + i)) {
                // 可以扩展
                result += 1;
            } else {
                break;
            }
        }
        return result;
    }
}
