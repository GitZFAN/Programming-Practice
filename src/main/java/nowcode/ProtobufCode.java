package nowcode;

import java.util.Arrays;

public class ProtobufCode {
    public static void main(String[] args) {
        ProtobufCode protobufCode = new ProtobufCode();
        String encode = protobufCode.encode(999);
        System.out.println("encode = " + encode);
        int decode = protobufCode.decode("0XE70X07");
        System.out.println("decode = " + decode);
    }

    private int decode(String code) {
        StringBuilder stringBuilder = new StringBuilder();

        int length = code.length();
        for (int i = 0; 4 * i < length; i++) {
            int j = length - 4 * i;
            String substring = code.substring(j - 4, j);
            String value = substring.substring(2, 4);
//            System.out.println("value = " + value);
            Integer integer = Integer.valueOf(value, 16);
//            System.out.println("integer = " + integer);
            String binaryString = Integer.toBinaryString(integer);
//            System.out.println("binaryString = " + binaryString);
            if (binaryString.length() == 8) {
                binaryString = binaryString.substring(1, 8);
            }
//            System.out.println("binaryString (after process) = " + binaryString);
            stringBuilder.append(binaryString);
        }
        String toString = stringBuilder.toString();
        return Integer.valueOf(toString, 2);
    }

    private String encode(int integer) {
        String binaryString = Integer.toBinaryString(integer);
        char[] charArray = binaryString.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[8];
        Arrays.fill(chars, '0');
        chars[0] = '1';

        int number = charArray.length / 7;

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 7; j++) {
                int x = 7 * i + j;
                int index = charArray.length - 1 - x;
                chars[7 - j] = charArray[index];
            }
            if (i == number - 1 && charArray.length % 7 == 0) {
                chars[0] = '0';
            }
            String s = String.valueOf(chars);
//            System.out.println("s = " + s);
            Integer value = Integer.valueOf(s, 2);
//            System.out.println("value = " + value);
            String hexString = Integer.toHexString(value);
//            System.out.println("hexString = " + hexString);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuilder.append("0X").append(hexString.toUpperCase());
        }
        if (charArray.length % 7 != 0) {
            Arrays.fill(chars, '0');
            for (int i = 7 * number; charArray.length - 1 - i >= 0; i++) {
                chars[7 - (i - 7 * number)] = charArray[charArray.length - 1 - i];
            }
            String s = String.valueOf(chars);
            Integer value = Integer.valueOf(s, 2);
            String hexString = Integer.toHexString(value);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuilder.append("0X").append(hexString.toUpperCase());
        }


        return stringBuilder.toString();
    }
}
