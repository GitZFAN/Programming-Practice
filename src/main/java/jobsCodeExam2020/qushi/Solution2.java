package jobsCodeExam2020.qushi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution2 {

    static String line;
    static int delete;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        delete = scanner.nextInt();

        for (int i = 0; i + delete < line.length(); i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            dfs(i, queue);
        }

        System.out.println(minValue);
    }

    private static void dfs(int startIndex, LinkedList<Integer> queue) {
        if (queue.size() == delete) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (!queue.contains(i)) {
                    stringBuilder.append(line.charAt(i));
                }
            }
            int valueOf = Integer.parseInt(stringBuilder.toString());
            minValue = Math.min(minValue, valueOf);
        }
        for (int i = startIndex; i < line.length(); i++) {
            queue.addLast(i);
            dfs(i + 1, queue);
            queue.removeLast();
        }
    }
}
