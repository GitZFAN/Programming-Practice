package jobsCodeExam2020.beike;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-10-26
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            HashSet<Integer> hashSet = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                hashSet.add(scanner.nextInt());
            }
            if (hasResult(hashSet, m)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean hasResult(HashSet<Integer> hashSet, int m) {
        for (Integer integer : hashSet) {
            if (m % integer == 0) {
                int target = m / integer;
                if (hashSet.contains(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
