package jobsCodeExam2020.webank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 数字的重排列
 *
 * @author 13585
 * @date 2020-10-15
 */
public class Solution3 {

    private static int anInt;
    private static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long aLong = scanner.nextLong();
        anInt = scanner.nextInt();
        String s = String.valueOf(aLong);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0' && !hashSet.contains(chars[i])) {
                swap(chars, 0, i);
                dfs(chars, 0);
                swap(chars, 0, i);
                hashSet.add(chars[i]);
            }
        }

        System.out.println(count);
    }

    private static void dfs(char[] chars, int startIndex) {
        if (startIndex == chars.length - 1) {
            String toString = String.valueOf(chars);
            System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
            long value = Long.parseLong(toString);
            System.out.println("value = " + value);
            if (value % anInt == 0) {
                count += 1;
            }
            return;
        }

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = startIndex + 1; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) {
                swap(chars, startIndex + 1, i);
                dfs(chars, startIndex + 1);
                swap(chars, startIndex + 1, i);
                hashSet.add(chars[i]);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
