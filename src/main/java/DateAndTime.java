import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 时间和日期相关处理测试
 *
 * @author fzhang
 * @date 2020-08-09
 */
public class DateAndTime {
    public static void main(String[] args) {
        // 格式：2020-08-23 17:22:26,408
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String time1 = "2020-08-27 08:00:00,101";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String startTime = "20/08/30 14:53:29";
        String endTime = "20/08/30 14:55:33";
        try {
            Date date1 = simpleDateFormat1.parse(time1);
            System.out.println("date1 = " + date1);
            System.out.println("date1.getTime() = " + date1.getTime());

            Date start = simpleDateFormat2.parse(startTime);
            System.out.println("start = " + start);
            System.out.println("start.getTime() = " + start.getTime());

            Date end = simpleDateFormat2.parse(endTime);
            System.out.println("end = " + end);
            System.out.println("end.getTime() = " + end.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 测试 String 的相关处理
        String installPath = "/home/zhangfan/hadoop-1.2.1";
        String[] split = installPath.split("/");
        System.out.println("split = " + Arrays.toString(split));
        for (int i = 0; i < split.length; i++) {
            System.out.println("split[" + i + "] = " + split[i]);
        }

        // 测试 1s 的操作数量级测试 1s 的操作数量级
        // 结果表明：当前本机的 CPU 1s 的运算次数为 3.5E9
        System.out.println("测试 1s 的计算机操作数量级");
        long begin = System.currentTimeMillis();
        long pow = (long) (Math.pow(10, 9) * 3.5);
        for (long i = 0; i < pow; i++) {
            long j = i * 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("计算次数：" + pow);
        System.out.println("(end - begin) = " + (end - begin));

    }
}
