package leetcode;

/**
 * 解法2：中心扩展法
 *
 * @author TheFan
 */
public class Solution5_2 {
    public static void main(String[] args) {
        Solution5_2 solution5_2 = new Solution5_2();
        String s = "cbbd";
        System.out.println(solution5_2.longestPalindrome(s));
    }

    int begin = 0;
    int maxLength = 1;

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            maxSingleCentrePalindrome(chars, i);
            if (i+1 < chars.length) {
                maxDoubleCentrePalindrome(chars, i, i+1);
            }
        }
        return s.substring(begin, begin+maxLength);
    }

    private void maxDoubleCentrePalindrome(char[] chars, int c, int c1) {
        if (chars[c] != chars[c1]) {
            return;
        } else if (maxLength < 2) {
            maxLength = 2;
            begin = c;
        }
        int maxHalfLen = Math.min(c, chars.length-1 - c1);
        /**
         * 判断是否有超过maxLength的回文子串的可能性
         */
        if ((maxHalfLen*2 + 2) <= maxLength){
            return;
        }

        for (int i = 1; c-i >= 0 && c1+i < chars.length; i++) {
            if (chars[c-i] != chars[c1+i]) {
                break;
            }
            int length = i*2 + 2;
            if (length > maxLength) {
                maxLength = length;
                begin = c-i;
            }
        }
    }

    private void maxSingleCentrePalindrome(char[] chars, int c) {
        int maxHalfLen = Math.min(c, chars.length - 1 - c);
        /**
         * 判断是否有超过maxLength的回文子串的可能性
         */
        if ((maxHalfLen*2 + 1) <= maxLength) {
            return;
        }

        for (int i = 1; c-i >= 0 && c+i < chars.length; i++) {
            if (chars[c-i] != chars[c+i]) {
                break;
            }
            int length = i*2 + 1;
            if (length > maxLength) {
                maxLength = length;
                begin = c-i;
            }
        }
    }
}
