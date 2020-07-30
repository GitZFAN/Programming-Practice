package nowcode.huawei;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            if (anInt == 0) {
                break;
            } else {
                System.out.println(anInt / 2);
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            if (input != 0) {
                System.out.println(maxDrink(input));
            } else {
                break;
            }
        }
    }

    private static int maxDrink(int input) {
        int result = 0;
        while (input >= 3) {
            int nDrink = input / 3;
            result += nDrink;
            input %= 3;
            input += nDrink;
        }
        if (input == 2) {
            result += 1;
        }

        return result;
    }
}
