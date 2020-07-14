package nowcode;

public class Solution_JZ49 {

    public static void main(String[] args) {
        Solution_JZ49 solution_jz49 = new Solution_JZ49();
        int strToInt = solution_jz49.StrToInt("123");
        System.out.println(strToInt);
    }

    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int result = 0;

        boolean flag = true;

        char first = str.charAt(0);

        if (str.length() == 1) {
            if ('0' <= first && first <= '9') {
                return first - '0';
            } else {
                return 0;
            }
        } else {
            if ('0' <= first && first <= '9') {
                result = first - '0';
            } else if ('+' == first) {
                flag = true;
            } else if ('-' == first) {
                flag = false;
            } else {
                return 0;
            }
        }

        for (int i = 1; i < str.length(); i++) {
            char num = str.charAt(i);
            if ('0' <= num && num <= '9') {
                result = result * 10 + num - '0';
            } else {
                return 0;
            }
        }

        if (!flag) {
            result *= -1;
        }

        return result;
    }
}
