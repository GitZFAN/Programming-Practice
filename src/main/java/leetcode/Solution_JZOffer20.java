package leetcode;

import java.util.Scanner;

/**
 * 剑指 Offer 20. 表示数值的字符串
 *
 * @author fzhang
 * @date 2020-09-02
 */
public class Solution_JZOffer20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Solution_JZOffer20 solution_jzOffer20 = new Solution_JZOffer20();
        boolean isNum = solution_jzOffer20.isNumber(s);
        System.out.println("isNum = " + isNum);

    }

    public boolean isNumber(String s) {
        String lowerCase = s.toLowerCase();
        String s1 = lowerCase.trim();
        int e = s1.indexOf("e");
        if (e != -1) {
            return isSignedInteger(s1, e + 1, s1.length() - 1) && isDouble(s1, 0, e - 1);
        } else {
            return isDouble(s1, 0, s1.length() - 1);
        }
    }

    private boolean isDouble(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        int point = s.indexOf(".");
        if (point != -1) {

            if (point == start) {
                // 小数点在开头
                return isUnSignedInteger(s, point + 1, end);
            }

            if (point == end) {
                // 小数点在末尾
                return isSignedInteger(s, start, end - 1);
            }

            if (point == start + 1) {
                // 小数点在第二位
                char c = s.charAt(start);
                if (c == '+' || c == '-') {
                    return isUnSignedInteger(s, point + 1, end);
                } else {
                    return isSignedInteger(s, 0, point - 1) && isUnSignedInteger(s, point + 1, end);
                }
            }

            return isSignedInteger(s, 0, point - 1) && isUnSignedInteger(s, point + 1, end);
        } else {
            return isSignedInteger(s, start, end);
        }

    }

    private boolean isSignedInteger(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (start == end) {
            return isUnSignedInteger(s, start, end);
        } else {
            char first = s.charAt(start);
            if (first == '+' || first == '-') {
                return isUnSignedInteger(s, start + 1, end);
            } else {
                return isUnSignedInteger(s, start, end);
            }
        }
    }

    private boolean isUnSignedInteger(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }


}
