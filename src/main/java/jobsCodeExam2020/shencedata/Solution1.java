package jobsCodeExam2020.shencedata;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-29
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<int[]> result = new ArrayList<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (charAt == '(') {
                stack.push(i);
            } else if (charAt == ')') {
                Integer pop = stack.pop();
                result.add(new int[]{pop, i});
            }
        }

        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println(result.size());
        for (int[] ints : result) {
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        }
    }
}
