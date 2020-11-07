import java.util.Scanner;

/**
 * 判断字符串A中俩字符互换位置后，是否能与字符串B相等
 *
 * @author 13585
 * @date 2020-08-25
 */
public class BrotherString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = null;
        String s2 = null;

        if (scanner.hasNext()) {
            s1 = scanner.nextLine();
        }

        // DONE: 2020/8/25 这里怎么在本地 IDE 中，控制输入流结束
        /** 关键在于理解: {@link Scanner#hasNext()} 方法 */
        // 参考链接: https://c.lanmit.com/bianchengkaifa/Java/69726.html

        if (!scanner.hasNext("#")) {
            s2 = scanner.nextLine();
        }

        if ((s1 != null && s2 != null)) {
            System.out.println(isEqual(s1, s2));
            return;
        }
        System.out.println("false");
    }

    static boolean isEqual(String s1, String s2) {
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                char aChar = chars[i];
                chars[i] = chars[j];
                chars[j] = aChar;
                String s = new String(chars);
                if (s2.equals(s)) {
                    return true;
                } else {
                    char aChar1 = chars[i];
                    chars[i] = chars[j];
                    chars[j] = aChar1;
                }
            }
        }
        return false;
    }
}
