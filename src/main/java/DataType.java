import java.util.Arrays;

/**
 * 基本数据类型相关问题
 *
 * @author fzhang
 * @date 2020-08-22
 */
public class DataType {

    /**
     * 分别定义8种基本类型的成员（实例）变量，查看默认值
     */
    byte abyte;
    short ashort;
    int anint;
    long along;

    float afloat;
    double adouble;

    char achar;

    boolean aboolean = false;

    public static void main(String[] args) {
        DataType dataType = new DataType();

        // 基本数据类型初始化
        System.out.println("dataType.abyte = " + dataType.abyte);
        System.out.println("dataType.ashort = " + dataType.ashort);
        System.out.println("dataType.anint = " + dataType.anint);
        System.out.println("dataType.along = " + dataType.along);

        System.out.println("dataType.afloat = " + dataType.afloat);
        System.out.println("dataType.adouble = " + dataType.adouble);

        System.out.println("dataType.achar = " + dataType.achar);

        System.out.println("dataType.aboolean = " + dataType.aboolean);

        // double 类型取整方法
        doubelToInteger();

        // 表达式类型赋值
        expressionValue();

        // 数组类型初始化
        arrayInitialization();

        // 经典字符顺序
        charSequencePrint();

        // 体会异常的概念和处理
        testException();

    }

    private static void doubelToInteger() {
        double a = 7;
        double b = 4;
        double x = a / b;
        // 向上取整
        System.out.println("Math.ceil(" + x + ") = " + Math.ceil(x));
        // 向下取整
        System.out.println("Math.floor(" + x + ") = " + Math.floor(x));
        // 四舍五入取整
        System.out.println("Math.round(" + x + ") = " + Math.round(x));
    }

    private static void expressionValue() {
        int a = 1, b = 2;
        boolean expr = (a < b);
        System.out.println("'" + a + "<" + b + "' = " + expr);
        System.out.println();
    }

    private static void arrayInitialization() {
        int[] ints0 = new int[3];
        int[] ints1 = {2, 4, 6};
        int[] ints = new int[]{1, 3, 5};
        System.out.println("ints = " + Arrays.toString(ints));
        System.out.println("ints0 = " + Arrays.toString(ints0));
        System.out.println("ints1 = " + Arrays.toString(ints1));
    }

    private static void charSequencePrint() {
        System.out.println();
        System.out.println("经典字符顺序");
        for (char i = '0'; i < 'z' + 1; i++) {
            System.out.print(i + " ");
            if (i % 32 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    private static void testException() {
        try {
            // 这里体会 整数除法 和 实数除法 的区别
            System.out.println(1 / 10);
            System.out.println(1.0 / 10);
            System.out.println(1 / 0);
            throw new Exception("hello");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
