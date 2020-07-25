import java.util.Scanner;

public class AliTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(eat(ints, n));
    }

    private static int eat(int[] ints, int n) {
        int result = 0;

        int minP = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ints[i] < minP) {
                minP = ints[i];
                index = i;
            }
        }
        if (index != -1) {
            for (int i = 0; i < n; i++) {
                ints[i] -= minP;
            }
            result += n * minP;
            result += eat(ints, index);
        }
        return result;
    }


}
