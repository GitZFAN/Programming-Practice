package jobsCodeExam2020.chubao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-27
 */
public class Solution5 {
    public static int N;
    public static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int M = scanner.nextInt();
        result = M;

        LinkedList<Integer> stack = new LinkedList<>();
        while (M != 0) {
            stack.push(M % 10);
            M /= 10;
        }

        int[] ints = new int[stack.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }

        dfs(ints, 0);

        System.out.println(result);
    }

    private static void dfs(int[] ints, int startIndex) {
        if (startIndex == ints.length) {
            int sum = 0;
            for (int anInt : ints) {
                sum = sum * 10 + anInt;
            }

            if (Math.abs(sum - N) < Math.abs(result - N)) {
                result = sum;
            } else if (Math.abs(sum - N) == Math.abs(result - N)) {
                result = Math.min(result, sum);
            }
            return;
        }

        for (int i = startIndex; i < ints.length; i++) {
            swap(ints, startIndex, i);
            dfs(ints, startIndex + 1);
            swap(ints, startIndex, i);
        }
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
