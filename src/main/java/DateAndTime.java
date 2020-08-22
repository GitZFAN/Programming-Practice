import java.text.SimpleDateFormat;

/**
 * 时间和日期相关处理测试
 *
 * @author fzhang
 * @date 2020-08-09
 */
public class DateAndTime {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int a = 1, b = 2;
        boolean is = (a < b);
        System.out.println("is = " + is);

        // 测试 1s 的操作数量级
        // 结果表明：当前本机的 CPU 1s 的运算次数为 3.5E9
        long begin = System.currentTimeMillis();
        long pow = (long) (Math.pow(10, 9) * 3.5);
        for (long i = 0; i < pow; i++) {
            long j = i * 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("(end - begin) = " + (end - begin));

    }
}
