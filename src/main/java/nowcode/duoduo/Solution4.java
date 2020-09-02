package nowcode.duoduo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 拼多多笔试题，求具有显著特征的数字个数
 *
 * @author fzhang
 * @date 2020-09-01
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] ints = new int[M];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }

        // 代表已有元素
        ArrayList<Integer> integers = new ArrayList<>(M);
        for (int anInt : ints) {
            boolean isAdd = true;

            for (int i = 0; i < integers.size(); i++) {
                Integer integer = integers.get(i);
                if (anInt % integer == 0) {
                    isAdd = false;
                    break;
                }
                if (integer % anInt == 0) {
                    integers.remove(i);
                    break;
                }
            }
            if (isAdd) {
                integers.add(anInt);
            }
        }

        System.out.println(countNum(N, integers));
    }

    private static int countNum(int N, ArrayList<Integer> integers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer integer : integers) {
            for (int i = 1; integer * i <= N; i++) {
                hashSet.add(integer * i);
            }
        }
        return hashSet.size();
    }
}
