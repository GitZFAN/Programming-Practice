package leetcode;

/**
 * 459. 重复的子字符串
 *
 * @author fzhang
 * @date 2020-08-24
 */
public class Solution459 {
    public static void main(String[] args) {
        String s = "abab";
        Solution459 solution459 = new Solution459();
        boolean repeatedSubstringPattern = solution459.repeatedSubstringPattern1(s);
        System.out.println("repeatedSubstringPattern = " + repeatedSubstringPattern);
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public boolean repeatedSubstringPattern1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        char start = s.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(start);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == start) {
                // i 之前的子串 有可能 经此开始重复构成原字符串
                String string = stringBuilder.toString();
                // 判断字符数量是否满足要求
                if ((length % string.length()) == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < (length / string.length()); j++) {
                        sb.append(string);
                    }
                    if (s.equals(sb.toString())) {
                        return true;
                    }
                }
            }
            stringBuilder.append(s.charAt(i));
        }

        return false;
    }
}
