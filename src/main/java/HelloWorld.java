public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello, world!");
        System.out.println("args size: " + args.length);
        String argsString = args[0];
        System.out.println("args[0]: " + argsString);
        String[] splits = argsString.split("\\+");
        System.out.println("total split size: " + splits.length);
        for (String s : splits) {
            System.out.println(s);
            System.out.println("superstep: " + s.split(":")[0]);
            System.out.println("worker: " + s.split(":")[1]);
        }
    }
}
