package jobsCodeExam2020.netease;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; line.length() - i > maxLength; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            hashMap.put('a', 0);
            hashMap.put('b', 0);
            hashMap.put('c', 0);
            hashMap.put('x', 0);
            hashMap.put('y', 0);
            hashMap.put('z', 0);

            for (int j = i; j < line.length(); j++) {
                int length = j - i + 1;

                char charAt = line.charAt(j);
                if (hashMap.containsKey(charAt)) {
                    Integer integer = hashMap.get(charAt);
                    hashMap.put(charAt, integer + 1);
                }

                if (evenAll(hashMap)) {
                    maxLength = Math.max(maxLength, length);
                }
            }

        }
        System.out.println(maxLength);
    }

    private static boolean evenAll(HashMap<Character, Integer> hashMap) {
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
