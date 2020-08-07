package leetcode;

/**
 * 866. 回文素数
 *
 * @author fzhang
 * @date 2020-08-07
 */
public class Solution866 {

    public static void main(String[] args) {
        int n = 10086;
        int reverse = Integer.reverse(n);
        System.out.println("reverse = " + reverse);
    }

    /**
     * 求出大于或等于 N 的最小回文素数
     *
     * @param N 下界
     * @return 大于或等于 N 的最小回文素数
     */
    public int primePalindrome(int N) {
        while (true) {
            // DONE: 8/7/20 这里值的考虑一下，是否回文和是否素数，哪个先判断
            // 实践证明：N == reverse(N) && ifPrime(N) 运行时间 小于 ifPrime(N) && N == reverse(N)
            if (N == reverse(N) && ifPrime(N)) {
                return N;
            }
            N += 1;
            if (N > 10_000_000 && N < 100_000_000) {
                N = 100_000_000;
            }
        }
    }

    private int reverse(int n) {
        int result = 0;
        while (n != 0) {
            int i = n % 10;
            result *= 10;
            result += i;
            n /= 10;
        }
        return result;
    }

    private boolean ifPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
