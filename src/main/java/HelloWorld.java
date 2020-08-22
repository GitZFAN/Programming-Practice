/**
 * 简单程序
 *
 * @author fzhang
 * @date 2020-08-22
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello, world!");
        System.out.print(" _   _      _ _    __        __         _     _ " + "\n" +
                "| | | | ___| | | __\\ \\      / /__  _ __| | __| |" + "\n" +
                "| |_| |/ _ \\ | |/ _ \\ \\ /\\ / / _ \\| '__| |/ _` |" + "\n" +
                "|  _  |  __/ | | (_) \\ V  V / (_) | |  | | (_| |" + "\n" +
                "|_| |_|\\___|_|_|\\___/ \\_/\\_/ \\___/|_|  |_|\\__,_|" + "\n");
        System.out.println();

        System.out.println("args.length = " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }

        // 从后往前遍历数组
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            int index = args.length - 1 - i;
            System.out.println("item" + i + ": " + "args[" + index + "] = " + args[index]);
        }
    }
}
