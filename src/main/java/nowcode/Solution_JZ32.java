package nowcode;

import java.util.ArrayList;

public class Solution_JZ32 {

    public static void main(String[] args) {
        System.out.println('0' - 0);
        System.out.println('9' - 0);
        System.out.println('A' - 0);
        System.out.println('Z' - 0);
        for (int i = 91; i < 97; i++) {
            char c = (char) i;
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println('a' - 0);
        System.out.println('z' - 0);
        String s1 = "33";
        String s2 = "320";
        System.out.println(s1.compareTo(s2));
    }

    /**
     * 使用字符串比较
     */
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        ArrayList<String> strings = new ArrayList<>();
        for (int number : numbers) {
            strings.add(String.valueOf(number));
        }

        strings.sort((o1, o2) -> {
            String pre = o1 + o2;
            String post = o2 + o1;
            return pre.compareTo(post);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
