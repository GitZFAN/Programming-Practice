package leetcode;

/**
 * 201. 数字范围按位与
 *
 * @author fzhang
 * @date 2020-08-24
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            shift += 1;
        }

        return m << shift;
    }
}
