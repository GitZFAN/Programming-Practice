package jobsCodeExam2020.qushi;

import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String midOrder = line.split(" ")[0];
        String postOrder = line.split(" ")[1];

        preOrder(midOrder, 0, midOrder.length() - 1,
                postOrder, 0, postOrder.length() - 1);
    }

    private static void preOrder(String midOrder, int midStart, int midEnd,
                                 String postOrder, int postStart, int postEnd) {
        if (midStart == midEnd) {
            System.out.print(midOrder.charAt(midStart));
            return;
        }

        char rootChar = postOrder.charAt(postEnd);
        int midIndex = midOrder.indexOf(rootChar);
        System.out.print(midOrder.charAt(midIndex));
        if (midIndex != midStart) {
            // 左子树存在 [midStart, midIndex-1]
            int leftLength = midIndex - midStart;
            preOrder(midOrder, midStart, midIndex - 1,
                    postOrder, postStart, postStart + leftLength - 1);
        }

        if (midIndex != midEnd) {
            // 右子树存在 [midIndex+1, midEnd]
            int rightLength = midEnd - midIndex;
            preOrder(midOrder, midIndex + 1, midEnd,
                    postOrder, postEnd - rightLength, postEnd - 1);
        }

    }
}
