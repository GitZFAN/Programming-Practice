import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 对于超大数据的处理
 *
 * @author fzhang
 * @date 2020-09-02
 */
public class BigNummber {
    public static void main(String[] args) {
        // 注意 不可变类 类似 String
        BigInteger bigInteger = new BigInteger("0");
        System.out.println("bigInteger = " + bigInteger);
        BigDecimal bigDecimal = new BigDecimal("1.0");
        System.out.println("bigDecimal = " + bigDecimal);

        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi + ".pow(5) = " + bi.pow(5));

        BigInteger i = new BigInteger("123456789000");
        System.out.println("i = " + i);
        System.out.println("i.longValue() = " + i.longValue());
        // java.lang.ArithmeticException: BigInteger out of long range
        try {
            System.out.println("i.multiply(i) = " + i.multiply(i));
            System.out.println("i.multiply(i).longValue() = " + i.multiply(i).longValue());
            System.out.println("i.multiply(i).longValueExact() = " + i.multiply(i).longValueExact());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigInteger n = new BigInteger("999999").pow(99);
        System.out.println("n.floatValue() = " + n.floatValue());

        bigDecimalUsage();
    }

    private static void bigDecimalUsage() {
        System.out.println("=========================================================================");
        BigDecimal d1 = new BigDecimal("123.4500");
        System.out.println(d1 + ".scale() = " + d1.scale());
        System.out.println(d1 + ".stripTrailingZeros().scale() = " + d1.stripTrailingZeros().scale());


        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d3 + " = " + d3);
        System.out.println(d3 + ".scale() = " + d3.scale());
        System.out.println(d3 + ".stripTrailingZeros() = " + d3.stripTrailingZeros());
        System.out.println(d3 + ".stripTrailingZeros().scale() = " + d3.stripTrailingZeros().scale());
    }
}
