package leetcode;

/**
 * 69. x 的平方根
 *
 * @author 13585
 * @date 2020-09-22
 */
public class Solution69 {
    /**
     * 因为浮点数的特性，需要设置精度，以判断两数“相等”
     */
    public static final double EPSILON = 1e-6;

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int sqrt = solution69.mySqrt(2147395599);
        System.out.println("sqrt = " + sqrt);

        try {
            double sqrtDouble = solution69.sqrtDouble(2);
            System.out.println("sqrtDouble = " + sqrtDouble);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 二分查找求 double 类型数值 x 的平方根
     *
     * @param x >=0 的double类型浮点数 x
     * @return Math.sqrt(x)
     * @throws Exception x < 0 时会抛出异常
     */
    public double sqrtDouble(final double x) throws Exception {
        if (compareDouble(x, 0) < 0) {
            throw new Exception("error");
        }

        double left = 0;
        double right = 0;

        if (compareDouble(x, 1) < 0) {
            // x ∈ [0, 1)
            left = x;
            right = 1;
            // 搜索区间：[x, 1]
        } else if (compareDouble(x, 1) >= 0) {
            // x ∈ [1, +∞)
            left = 1;
            right = x;
            // 搜索区间：[1, x]
        }

        while (compareDouble(left, right) < 0) {
            double mid = left + (right - left) / 2.0;
            double square = mid * mid;
            if (compareDouble(square, x) == 0) {
                return mid;
            } else if (compareDouble(square, x) < 0) {
                left = mid;
            } else if (compareDouble(square, x) > 0) {
                right = mid;
            }
        }

        return left;
    }

    /**
     * 比较两个浮点数的大小
     *
     * @param d1 第一个数
     * @param d2 第二个数
     * @return -1:0:1 分别表示 d1 <:=:> d2
     */
    private int compareDouble(double d1, double d2) {
        if (Math.abs(d1 - d2) <= EPSILON) {
            return 0;
        }
        if (d1 < d2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * 二分查找法求整数平方根
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 非负整数
     * @return x的平方根（结果只保留整数的部分，小数部分将被舍去）
     */
    public int mySqrt(int x) {
        // 由于 x 平方根的整数部分 ans 是满足 k^2 ≤ x 的最大 k 值，
        // 因此我们可以对 k 进行二分查找，从而得到答案。

        // 二分查找的下界为 0，上界可以粗略地设定为 x
        int left = 0;
        int right = x;
        // 注意，这里是关键
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 注意这里需要改成 long，否则存在溢出问题
            long square = ((long) mid) * ((long) mid);
            if (square <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
