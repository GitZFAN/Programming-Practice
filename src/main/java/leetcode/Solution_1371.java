package leetcode;

import java.util.Arrays;

public class Solution_1371 {
    public static void main(String[] args) {
        Solution_1371 solution = new Solution_1371();
        String s = "bcbcbc";
        System.out.println(solution.findTheLongestSubstring(s));
    }

    public int findTheLongestSubstring(String s) {
        int maxLength = 0;
        int[] vowels = {1, 1, 1, 1, 1};
        for (int i = 0; i < s.length(); i++) {
            if (maxLength != 0 && (s.length()-i) < maxLength) {
                break;
            }
            StringBuilder sBuilder = new StringBuilder();
            Arrays.fill(vowels, 1);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                sBuilder.append(c);
                switch (c) {
                    case 'a':
                        vowels[0] *= -1;
                        break;
                    case 'e':
                        vowels[1] *= -1;
                        break;
                    case 'i':
                        vowels[2] *= -1;
                        break;
                    case 'o':
                        vowels[3] *= -1;
                        break;
                    case 'u':
                        vowels[4] *= -1;
                        break;
                    default:
                        break;
                }
                if (isEven(vowels)) {
                    int length = sBuilder.length();
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }

    boolean isEven(int[] vowels) {
        for (int vowel : vowels) {
            if (vowel < 0) {
                return false;
            }
        }
        return true;
    }
}
