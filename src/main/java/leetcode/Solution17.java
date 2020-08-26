package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author fzhang
 * @date 2020-08-26
 */
public class Solution17 {

    String digitsString;
    char[] chars;
    HashMap<Character, String> hashMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        digitsString = digits;
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        chars = new char[digits.length()];

        return fillString(0);
    }

    private List<String> fillString(int index) {
        List<String> result = new LinkedList<>();
        if (index == digitsString.length() - 1) {
            char c = digitsString.charAt(index);
            String mightChar = hashMap.get(c);
            for (int i = 0; i < mightChar.length(); i++) {
                chars[index] = mightChar.charAt(i);

                // chars[] 并不能直接通过 toString() 方法直接转成 String
                // result.add(Arrays.toString(chars));

                StringBuilder stringBuilder = new StringBuilder();
                for (char aChar : chars) {
                    stringBuilder.append(aChar);
                }
                result.add(stringBuilder.toString());
            }
            return result;
        }

        char c = digitsString.charAt(index);
        String mightChar = hashMap.get(c);
        for (int i = 0; i < mightChar.length(); i++) {
            chars[index] = mightChar.charAt(i);
            List<String> strings = fillString(index + 1);
            result.addAll(strings);
        }

        return result;
    }
}
