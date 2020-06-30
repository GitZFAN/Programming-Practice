package leetcode;

import java.util.Arrays;

public class Interview_08_11 {

    public static void main(String[] args) {
        Interview_08_11 interview_08_11 = new Interview_08_11();
        System.out.println(interview_08_11.waysToChange(26));
    }

    int[] coins = {1, 5, 10, 25};
    int mod = 1000000007;

    public int waysToChange(int n) {

        int result = 0;

        // 使用递归方法求解
//        result = chargeWithNcoin(4, n);

        /*
         * 使用数组空间存储子问题，优化空间复杂度
         * 使用空间换取时间，避免计算重叠子问题
         * */
        int[] resultArray = new int[n+1];

        // 初始化数组
        Arrays.fill(resultArray, 1);

        for (int i = 1; i < coins.length; i++) {
            int maxCoin = coins[i];
            for (int j = 1; j < resultArray.length; j++) {
                if (j >= maxCoin) {
                    resultArray[j] += resultArray[j - maxCoin];
                    if (resultArray[j] > mod) {
                        resultArray[j] %= mod;
                    }
                }
            }
        }
        result = resultArray[n];
        return result;
    }

    private int chargeWithNcoin(int cType, int money) {
        if (cType == 1) {
            return 1;
        }
        int result = 0;
        int maxCoin = coins[cType - 1];

        /*
         * 原始动态规划
         * */
        /*for (int i = 0; i <= money / maxCoin; i++) {
            int leftMoney = money - maxCoin * i;
            result += chargeWithNcoin(cType-1, leftMoney);
            if (result > mod) {
                result %= mod;
            }
        }*/

        /*
         * 优化时间复杂度
         * 这样我们就可以把原来的三重循环变成两重循环，
         * 求解每个状态的时间代价是 O(1)，总的时间代价为 O(4×(n+1))。
         * */
        if (money >= maxCoin) {
            result += chargeWithNcoin(cType-1, money)
                    + chargeWithNcoin(cType, money-maxCoin);
        } else {
            result += chargeWithNcoin(cType-1, money);
        }

        return result;
    }
}
