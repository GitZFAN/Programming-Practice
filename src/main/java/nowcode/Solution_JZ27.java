package nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution_JZ27 {

    HashMap<String, ArrayList<String>> hashMap;

    public ArrayList<String> Permutation(String str) {
        int length = str.length();
        int capacity = 1;
        for (int i = length; i > 1; i--) {
            capacity *= i;
        }

        hashMap = new HashMap<>(capacity);

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String string = String.valueOf(charArray);

        return permutation(string);
    }

    private ArrayList<String> permutation(String string) {
        if (string.length() == 1) {
            ArrayList<String> list = new ArrayList<>(1);
            list.add(string);
            return list;
        }
        ArrayList<String> result = new ArrayList<>(string.length());

        HashSet<Character> hashSet = new HashSet<>(string.length());
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!hashSet.contains(c)) {
                String pre = string.substring(0, i);
                String post = string.substring(i + 1);
                String newString = pre + post;
                ArrayList<String> arrayList;

                if (hashMap.containsKey(newString)) {
                    arrayList = hashMap.get(newString);
                } else {
                    arrayList = permutation(newString);
                }

                for (String s : arrayList) {
                    String s1 = c + s;
                    result.add(s1);
                }
                hashSet.add(c);
            }
        }

        return result;
    }
}
