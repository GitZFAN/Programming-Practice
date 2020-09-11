package nowcode.company360;

import nowcode.xiaomi.Solution1;

import java.util.Scanner;

/**
 * 判断密码是否符合规范
 *
 * @author 13585
 * @date 2020-09-11
 * @see Solution1
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (isValidPassword(line)) {
                System.out.println("Ok");
            } else {
                System.out.println("Irregular password");
            }
        }
    }

    private static boolean isValidPassword(String line) {
        if (line.length() < 8) {
            return false;
        }

        boolean hasDigital = false;
        boolean hasBig = false;
        boolean hasSmall = false;
        boolean hasChar = false;

        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (Character.isDigit(charAt)) {
                hasDigital = true;
                continue;
            }
            if (Character.isUpperCase(charAt)) {
                hasBig = true;
                continue;
            }
            if (Character.isLowerCase(charAt)) {
                hasSmall = true;
            } else {
                hasChar = true;
            }
        }

        return hasDigital && hasBig && hasSmall && hasChar;
    }
}
