package nowcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_JZ34 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        ArrayList<Character> characters = new ArrayList<>(10010);
        HashMap<Character, Integer> hashMap = new HashMap<>(10010);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (characters.contains(c)) {
                Integer frequency = hashMap.get(c);
                frequency += 1;
                hashMap.put(c, frequency);
            } else {
                hashMap.put(c, 1);
                characters.add(c);
            }
        }

        for (Character c : characters) {
            if (hashMap.get(c) == 1) {
                return str.indexOf(c);
            }
        }
        return -1;
    }
}
