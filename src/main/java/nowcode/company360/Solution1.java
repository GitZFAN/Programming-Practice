package nowcode.company360;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 企业管理
 *
 * @author 13585
 * @date 2020-09-11
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 上班列表
        LinkedList<Integer> goWork = new LinkedList<>();
        // 下班列表
        LinkedList<Integer> offWork = new LinkedList<>();
        // 所有有记录的员工集合
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();

            hashSet.add(i1);

            if (i2 == 1) {
                goWork.add(i1);
            } else {
                offWork.add(i1);
            }
        }

        HashSet<Integer> notImpossible = new HashSet<>();

        if (goWork.size() < hashSet.size()) {
            // 存在员工上班的纪录被省略
            notImpossible.addAll(goWork);
        } else {
            for (int i = 1; i < goWork.size(); i++) {
                notImpossible.add(goWork.get(i));
            }
            if (goWork.size() != 0) {
                Integer integer = goWork.getFirst();
                if (offWork.contains(integer)) {
                    if (offWork.size() != hashSet.size() || !offWork.getLast().equals(integer)) {
                        notImpossible.add(integer);
                    }
                }
            }
        }

        if (offWork.size() < hashSet.size()) {
            // 存在员工下班的记录被省略
            notImpossible.addAll(offWork);
        } else {
            for (int i = 0; i < offWork.size() - 1; i++) {
                notImpossible.add(offWork.get(i));
            }
            if (offWork.size() != 0) {
                Integer integer = offWork.getLast();
                if (goWork.contains(integer)) {
                    if (goWork.size() != hashSet.size() || !goWork.getFirst().equals(integer)) {
                        notImpossible.add(integer);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!notImpossible.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }
}
