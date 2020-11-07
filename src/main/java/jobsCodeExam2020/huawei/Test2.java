package jobsCodeExam2020.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int anInt = scanner.nextInt();
                // 去重
                if (!list.contains(anInt)) {
                    list.add(anInt);
                }
            }
            // 排序
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            // 输出
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
