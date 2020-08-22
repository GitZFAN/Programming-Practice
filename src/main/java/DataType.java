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

        System.out.println("dataType.abyte = " + dataType.abyte);
        System.out.println("dataType.ashort = " + dataType.ashort);
        System.out.println("dataType.anint = " + dataType.anint);
        System.out.println("dataType.along = " + dataType.along);

        System.out.println("dataType.afloat = " + dataType.afloat);
        System.out.println("dataType.adouble = " + dataType.adouble);

        System.out.println("dataType.achar = " + dataType.achar);

        System.out.println("dataType.aboolean = " + dataType.aboolean);

        // 体会异常的概念和处理
        try {
            // 这里体会 整数除法 和 实数除法 的区别
            System.out.println(1 / 10);
            System.out.println(1.0 / 10);
            System.out.println(1 / 0);
            throw new Exception("hello");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        for (int i = 10; i > 0; i--) {
            System.out.println("item: " + i);
        }
    }
}
