package nowcode.huawei;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (line != null && line.length() != 0) {
                if (line.contains("x")) {
                    line = line.split("x")[1];
                }
                Integer integer = Integer.valueOf(line, 16);
                System.out.println(integer);
            } else {
                break;
            }
        }
    }
}
