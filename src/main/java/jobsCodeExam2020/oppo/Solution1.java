package jobsCodeExam2020.oppo;

/**
 * 查找所有回文子串（长度大于1）
 *
 * @author 13585
 * @date 2020-09-23
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.printPalindrome("woppocom");
    }

    private void printPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // 以 [s.charAt(i)] 为中心扩展
            for (int j = 1; ; j++) {
                int start = i - j;
                int end = i + j;
                if (start >= 0 && end < s.length()) {
                    if (s.charAt(start) == s.charAt(end)) {
                        System.out.println(s.substring(start, end + 1));
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            int right = i + 1;
            // 以 [s.charAt(i), s.charAt(i+1)] 为中心扩展
            for (int j = 0; ; j++) {
                int start = i - j;
                int end = right + j;
                if (start >= 0 && end < s.length()) {
                    if (s.charAt(start) == s.charAt(end)) {
                        System.out.println(s.substring(start, end + 1));
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
