package jobsCodeExam2020.sougou;

import java.util.LinkedList;

/**
 * @author 13585
 * @date 2020-09-25
 */
public class Solution1 {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     *
     * @param n    int整型 选择题总数
     * @param k    int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve(int n, int k, String str1, String str2) {
        // write code here
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                ints[i] = 1;
            }
        }

        LinkedList<Integer> path = new LinkedList<>();

        dfs(ints, n, 0, k, path);

        return new Interval(min, max);
    }

    private void dfs(int[] ints, int n, int startIndex, int k, LinkedList<Integer> path) {
        if (k == 0) {
            int right = 0;
            int error = 0;
            for (int i = 0; i < ints.length; i++) {
                if (path.contains(i)) {
                    if (ints[i] == 1) {
                        right += 1;
                    } else {
                        error += 1;
                    }
                } else {
                    if (ints[i] == 1) {
                        error += 1;
                    }
                }
            }

            int remain = n - right - error;

            int tempMax = right + remain;
            int tempMin = right;

            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);
        }

        for (int i = startIndex; i < n; i++) {
            path.offerLast(i);
            dfs(ints, n, i + 1, k - 1, path);
            path.pollLast();
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}