package jobsCodeExam2020.chubao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-27
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splits = line.split(" ");
        ArrayList<String> arrayList = new ArrayList<>(splits.length);
        arrayList.addAll(Arrays.asList(splits));

        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        String line1 = scanner.nextLine();

        for (String s : arrayList) {
            if (line1.contains(s)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    stringBuilder.append("*");
                }
                String toString = stringBuilder.toString();
                System.out.println(line1.replace(s, toString));
                return;
            }
        }

        System.out.println(line1);
    }
}
