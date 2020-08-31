package leetcode;

/**
 * 557. 反转字符串中的单词 III
 *
 * @author fzhang
 * @date 2020-08-31
 */
public class Solution557 {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        String[] splits = s.split(" ");
        for (String split : splits) {
            String reverseSplit = reverseString(split);
            stringBuilder.append(reverseSplit);
            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
