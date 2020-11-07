package jobsCodeExam2020.shencedata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-29
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() == 0) {
            return;
        }

        ArrayList<Character> list1 = new ArrayList<>(line.length());
        ArrayList<Integer> list2 = new ArrayList<>(line.length());

        char pre = line.charAt(0);
        int count = 1;
        for (int i = 1; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (charAt != pre) {
                list1.add(pre);
                list2.add(count);
                pre = charAt;
                count = 1;
            } else {
                count += 1;
            }
        }
        list1.add(pre);
        list2.add(count);

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + "" + list2.get(i));
        }
    }
}
