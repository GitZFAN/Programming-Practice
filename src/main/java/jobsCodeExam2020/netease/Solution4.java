package jobsCodeExam2020.netease;

import java.util.*;

/**
 * 被7整除的所有元素和最大子集
 *
 * @author 13585
 * @date 2020-09-12
 */
public class Solution4 {
    public static final int MOD = 7;
    static int minSubsetSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int num = scanner.nextInt();
        ArrayList<Integer> integers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            int anInt = scanner.nextInt();
            integers.add(anInt);
            sum += anInt;
        }

        if (sum % MOD == 0) {
            System.out.println(sum);
        }

        Collections.sort(integers);

        // DONE: 2020/9/12 如何得到所有子集
        // 回溯算法

        minSubsetSum = sum;

        LinkedList<Integer> path = new LinkedList<>();
        dfs(integers, 0, sum, 0, path);

        System.out.println("minSubsetSum = " + minSubsetSum);
    }

    private static void dfs(ArrayList<Integer> integers, int subsetSum, int totalSum, int startIndex, LinkedList<Integer> path) {
        if (minSubsetSum <= subsetSum) {
            // 剪枝
            return;
        }

        if ((totalSum - subsetSum) % MOD == 0) {
            // 符合终止条件
            minSubsetSum = subsetSum;
            System.out.println("subsetSum = " + subsetSum);
            for (int i = 0; i < path.size() - 1; i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println(path.get(path.size() - 1));

            System.out.print("元素和最大子集：");
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : integers) {
                if (!path.contains(integer)) {
                    stringBuilder.append(integer).append(" ");
                }
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
            return;
        }

        // 回溯
        for (int i = startIndex; i < integers.size(); i++) {
            path.offerLast(integers.get(i));
            dfs(integers, subsetSum + integers.get(i), totalSum, i + 1, path);
            path.pollLast();
        }
    }
}
