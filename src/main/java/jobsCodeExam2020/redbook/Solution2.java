package jobsCodeExam2020.redbook;

import java.util.Scanner;

/**
 * 最小切割子串数量
 *
 * @author 13585
 * @date 2020-09-12
 */
public class Solution2 {

    /**
     * 请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int[][] ints = new int[length][length];
        // 动态规划
        for (int i = 0; i < length; i++) {
            ints[i][i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j+i < length; j++) {
                int min = Integer.MAX_VALUE;
                String substring = s.substring(j, j + i + 1);
                // 求字符串 [j, j+i] 切割的最小字串数
                for (int k = j; k <= j + i; k++) {
                    char charAt = s.charAt(k);
                    int lastIndexOf = substring.lastIndexOf(charAt);

                    int pre = 0;
                    int mid = 1;
                    int post = 0;
                    if (k != j) {
                        pre = ints[j][lastIndexOf+j-1];
                    }
                    if (lastIndexOf+j != j+i) {
                        post = ints[lastIndexOf+j+1][j+i];
                    }
                    min = Math.min(min, pre+mid+post);
                }
                ints[j][j+i] = min;
            }
        }

        return ints[0][length-1];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        // 输入样例 abaccd
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = solution(_s);
        System.out.println(String.valueOf(res));

    }
}
