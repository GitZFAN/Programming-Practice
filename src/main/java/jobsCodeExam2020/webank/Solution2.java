package jobsCodeExam2020.webank;

import java.util.Scanner;

/**
 * 节奏小师
 *
 * @author 13585
 * @date 2020-10-15
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int countP = 0;
        int countM = 0;
        int goat = 0;
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (charAt == 'P') {
                countP += 1;
                if (countP > 3) {
                    goat += 250;
                } else {
                    goat += 200;
                }
            } else if (charAt == 'G') {
                countP = 0;
                goat += 100;
            } else if (charAt == 'M') {
                countM += 1;
                if (countM == 3) {
                    goat = 0;
                    break;
                } else {
                    countP = 0;
                }
            }
        }
        System.out.println(goat);
    }
}
