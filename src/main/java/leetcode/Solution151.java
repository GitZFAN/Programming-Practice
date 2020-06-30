package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution151 {

    public static void main(String[] args) {
        String line = "the sky is blue";
        System.out.println(line);
        Solution151 solution = new Solution151();

        String reverseWords = solution.reverseWords(line);

        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        List<String> wordsStack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                int j = i;
                for ( ; j < s.length(); j++) {
                    if (s.charAt(j) == ' ') {
                        String word = s.substring(i, j);
                        wordsStack.add(word);
                        i = j;
                        break;
                    }
                    if (j == s.length()-1) {
                        String word = s.substring(i, j+1);
                        wordsStack.add(word);
                        i = j;
                    }
                }
            }
        }

        String result = "";
        for (int i = wordsStack.size() -1; i >= 0 ; i--) {
            result += wordsStack.get(i);
            if (i != 0) {
                result +=  " ";
            }
        }
        return result;
    }
}
