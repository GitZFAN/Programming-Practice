package leetcode;

/**
 * 7. 整数反转
 *
 * @author fzhang
 * @date 2020-08-22
 */
public class Solution7 {
    public static void main(String[] args) {
        int x = -7;
        System.out.println(x);
        System.out.println(x / 10);
        System.out.println(x % 10);
    }

    /**
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x 输入整数
     * @return 反转之后的整数值
     */
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int r = x % 10;
            // 这里需要判断result是否会溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && r < -8)) {
                return 0;
            }

            result = result * 10 + r;

            x /= 10;
        }

        return result;
    }
}
