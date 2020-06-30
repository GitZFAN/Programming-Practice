package leetcode;

public class Solution_608 {
    public static void main(String[] args) {
        String s = "abcbda";
        Solution_608 solution = new Solution_608();
        System.out.println(solution.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            char front = s.charAt(i);
            char later = s.charAt(length - 1 - i);
            if (front != later) {
                StringBuilder deleteFrontChar = new StringBuilder(s).deleteCharAt(i);
                if (deleteFrontChar.toString().equals(deleteFrontChar.reverse().toString())) {
                    return true;
                }
                StringBuilder deleteLaterChar = new StringBuilder(s).deleteCharAt(length - 1 - i);
                return deleteLaterChar.toString().equals(deleteLaterChar.reverse().toString());
            }
        }
        return true;
    }
}
