package nowcode;

import mytool.IntComplementalCode;

public class Solution_JZ11 {
    public static void main(String[] args) {
        int integer = 0;
        String binaryString = "";
        String complementString = "";

        integer = 7;
        binaryString = Integer.toBinaryString(integer);
        complementString = IntComplementalCode.getComplementalCode(integer);

        System.out.printf("%11s = %32s\n", integer, binaryString);
        System.out.printf("%11s = %32s\n", integer, complementString);

        integer = Integer.MAX_VALUE;
        binaryString = Integer.toBinaryString(integer);
        complementString = IntComplementalCode.getComplementalCode(integer);

        System.out.printf("%11s = %32s\n", integer, binaryString);
        System.out.printf("%11s = %32s\n", integer, complementString);

        integer = -1;
        binaryString = Integer.toBinaryString(integer);
        complementString = IntComplementalCode.getComplementalCode(integer);

        System.out.printf("%11s = %32s\n", integer, binaryString);
        System.out.printf("%11s = %32s\n", integer, complementString);

        integer = -Integer.MAX_VALUE;
        binaryString = Integer.toBinaryString(integer);
        complementString = IntComplementalCode.getComplementalCode(integer);

        System.out.printf("%11s = %32s\n", integer, binaryString);
        System.out.printf("%11s = %32s\n", integer, complementString);

        integer = Integer.MIN_VALUE;
        binaryString = Integer.toBinaryString(integer);
        complementString = IntComplementalCode.getComplementalCode(integer);

        System.out.printf("%11s = %32s\n", integer, binaryString);
        System.out.printf("%11s = %32s\n", integer, complementString);

    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count += 1;
            }
            n = (n >>> 1);
        }
        return count;
    }
}
