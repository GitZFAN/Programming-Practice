package leetcode;

import java.util.LinkedList;

/**
 * 43. 字符串相乘
 *
 * @author fzhang
 * @date 2020-08-13
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        // 判断乘积是否为0
        if (num1.startsWith("0") || num2.startsWith("0")) {
            return "0";
        }

        // 保证 num1 为长度较短的数字
        if (num2.length() < num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        LinkedList<LinkedList<Character>> results = new LinkedList<>();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 挨个从 num1 中取出元素同 num2 进行乘积操作
        for (int i = 0; i < chars1.length; i++) {
            // 从后往前取
            int index = chars1.length - 1 - i;
            int number = chars1[index] - '0';
            if (number != 0) {
                LinkedList<Character> characters = singleMultiply(chars2, number, i);
                if (characters.size() != 0) {
                    results.add(characters);
                }
            }
        }

        // 将乘积进行累加求和
        LinkedList<Character> sum = new LinkedList<>();
        sum.add('0');
        for (LinkedList<Character> charList : results) {
            sum = add(sum, charList);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : sum) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    private LinkedList<Character> add(LinkedList<Character> list1, LinkedList<Character> list2) {
        // 保证 list1 为较短的数字
        if (list2.size() < list1.size()) {
            LinkedList<Character> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        LinkedList<Character> result = new LinkedList<>();

        int flag = 0;
        int i = 0;
        for (; i < list1.size(); i++) {
            int index1 = list1.size() - 1 - i;
            int nb1 = list1.get(index1) - '0';
            int index2 = list2.size() - 1 - i;
            int nb2 = list2.get(index2) - '0';

            int sum = nb1 + nb2 + flag;
            if (sum > 9) {
                flag = sum / 10;
                sum %= 10;
                result.addFirst((char) ('0' + sum));
            } else {
                flag = 0;
                result.addFirst((char) ('0' + sum));
            }
        }

        for (; i < list2.size(); i++) {
            int index = list2.size() - 1 - i;
            int value = list2.get(index) - '0';
            int sum = value + flag;

            if (sum > 9) {
                flag = sum / 10;
                sum %= 10;
                result.addFirst((char) ('0' + sum));
            } else {
                flag = 0;
                result.addFirst((char) ('0' + sum));
            }
        }

        if (flag != 0) {
            result.addFirst((char) ('0' + flag));
        }

        return result;
    }

    private LinkedList<Character> singleMultiply(char[] chars, int number, int order) {
        LinkedList<Character> result = new LinkedList<>();
        for (int i = 0; i < order; i++) {
            result.add('0');
        }

        int flag = 0;

        for (int i = 0; i < chars.length; i++) {
            // 从后往前取
            int index = chars.length - 1 - i;
            int value = chars[index] - '0';
            int multiply = value * number;
            multiply += flag;

            if (multiply > 9) {
                flag = multiply / 10;
                multiply %= 10;
                result.addFirst((char) ('0' + multiply));
            } else {
                flag = 0;
                result.addFirst((char) ('0' + multiply));
            }

        }

        if (flag != 0) {
            result.addFirst((char) ('0' + flag));
        }

        return result;
    }
}
