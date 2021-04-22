package leetcode;

/**
 * 190. 颠倒二进制位
 *
 * @author fzhang
 * @date 2021-03-29
 */
public class Solution190 {

    public static void main(String[] args) {
        String s = Integer.toBinaryString(-1);
        System.out.println("s = " + s);

        int i = 0;
        System.out.println("Integer.toBinaryString(~i) = " + Integer.toBinaryString(~i));

        Integer integer = Integer.valueOf("-0111111111111111111111111111111", 2);
        System.out.println(integer);


    }

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     * <p>
     * note: you need treat n as an unsigned value
     *
     * @param n 无符号整数
     * @return 颠倒后的整数
     */
    public int reverseBits(int n) {
        // 得到输入整数的补码
        String binaryString = Integer.toBinaryString(n);

        // 正数补码位数补全
        if (binaryString.length() < 32) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (32 - binaryString.length()); i++) {
                builder.append(0);
            }
            binaryString = builder.toString() + binaryString;
        }

        StringBuilder stringBuilder = new StringBuilder(binaryString);
        // 得到输出补码
        String reverse = stringBuilder.reverse().toString();

        // 输出补码表示的值
        if (reverse.charAt(0) == '1') {
            // 若输出为负数，需要先进行补码转原码

            // 问题定义：已知一个负数的补码（String类型），求该负数的整数值（10进制）
            // TODO: 3/29/21 需要一个更加简便的方法

            // 简便按位取反，利用位运算中的取反操作符
            /*String substring = reverse.substring(1);
            Integer value = Integer.valueOf(substring, 2);
            value = ~value + 1;

            String replaceFirst = Integer.toBinaryString(value).replaceFirst("1", "-");

            return Integer.valueOf(replaceFirst, 2);*/

            // 按位取反
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < reverse.length(); i++) {
                if (reverse.charAt(i) == '0') {
                    builder.append(1);
                } else {
                    builder.append(0);
                }
            }
            Integer integer = Integer.valueOf(builder.toString(), 2);

            return -1 * (integer + 1);
        }
        return Integer.valueOf(reverse, 2);
    }
}
