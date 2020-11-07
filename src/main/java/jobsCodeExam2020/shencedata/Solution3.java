package jobsCodeExam2020.shencedata;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求无序单链表的中位数
 *
 * @author 13585
 * @date 2020-09-29
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        // TODO: 2020/9/29 求无序单链表的中位数，复杂度低于O(nlogn)
        Arrays.sort(ints);
        System.out.println(ints[ints.length / 2]);
    }
}
