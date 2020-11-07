package jobsCodeExam2020.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i + maxLength < line.length(); i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = i; j < line.length(); j++) {
                char charAt = line.charAt(j);
                if (hashSet.contains(charAt)) {
                    int length = hashSet.size();
                    maxLength = Math.max(maxLength, length);
                }
                hashSet.add(charAt);
            }
        }

        System.out.println(maxLength);
    }
}
