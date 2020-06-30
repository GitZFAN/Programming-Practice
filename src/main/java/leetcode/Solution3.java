package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "pwwkew";
        int lengthOfLongestSubstring = solution3.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }

    public int lengthOfLongestSubstring(String s) {
        int longestS = 0;

        for (int i = 0; i < s.length(); i++) {
            String longestStr = String.valueOf(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                if (!longestStr.contains(String.valueOf(s.charAt(j)))) {
                    longestStr = s.substring(i, j+1);
                } else {
                    break;
                }
            }
            if (longestStr.length() > longestS) {
                longestS = longestStr.length();
            }
        }
        return longestS;
    }
}
