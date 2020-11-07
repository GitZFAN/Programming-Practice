package jobsCodeExam2020.meituan;

/**
 * N阶台阶
 * 只能一次上1阶，或者2阶。
 * 爬到最后总共有多少种爬法
 *
 * @author 13585
 * @date 2020-11-07
 */
public class Interview2 {

    public static void main(String[] args) {
        Interview2 interview2 = new Interview2();
        int nums = interview2.numOfPaths(5, 3);
        System.out.println("nums = " + nums);
    }

    /**
     * 求爬到顶端总共有多少种爬法
     *
     * @param totalHeight   一共有多少级台阶
     * @param maxSingleStep 每步能上的最大台阶数
     * @return 爬到顶端的方法数
     */
    public int numOfPaths(int totalHeight, int maxSingleStep) {
        int[] ints = new int[totalHeight + 1];

        ints[0] = 1;
        ints[1] = 1;

        for (int i = 2; i < ints.length; i++) {
            int sum = 0;
            for (int j = 1; j <= maxSingleStep; j++) {
                if ((i - j) >= 0) {
                    sum += ints[i - j];
                }
            }
            ints[i] = sum;
        }

        return ints[totalHeight];
    }
}
