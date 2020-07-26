package mytool;

import java.util.Scanner;

/**
 * 原码 反码 补码的英文：baitrue form；base minus one's complement；complement
 * 原码true code 补码 complemental code 反码ones-complement code
 */
public class IntComplementalCode {

    public static void main(String[] args) {
        System.out.println("Note: get the complement code of an integer...");
        System.out.print("please input an integer " +
                "(range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + "): ");

        int integer = new Scanner(System.in).nextInt();
        String complementalCode = getComplementalCode(integer);
        System.out.printf("%11s = %32s\n", integer, complementalCode);
    }

    public static String getComplementalCode(int integer) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (int i = 31; i >= 0; i--) {
            int n = integer >> i;
            stringBuilder.append((n & 1));
        }
        return stringBuilder.toString();
    }
}
