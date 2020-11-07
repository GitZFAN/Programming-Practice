package jobsCodeExam2020.aiqiyi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(ints);

        LinkedList<Integer> path = new LinkedList<>();
        dfs(ints, 0, path, 0);
    }

    private static void dfs(int[] ints, int startIndex, LinkedList<Integer> path, int currentSum) {
        if (path.size() == 3) {
            if (currentSum == 0) {
                // 倒序输出
                for (int i = path.size() - 1; i > 0; i--) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println(path.get(0));
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < ints.length; i++) {
            if (currentSum + ints[i] > 0) {
                break;
            } else {
                if (!hashSet.contains(ints[i])) {
                    hashSet.add(ints[i]);
                    path.push(ints[i]);
                    dfs(ints, i + 1, path, currentSum + ints[i]);
                    path.pop();
                }
            }
        }
    }
}
