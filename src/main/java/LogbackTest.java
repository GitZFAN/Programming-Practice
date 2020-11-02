import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: LogbackTest
 * Description:
 * logback日志测试
 * Version:1.0.0
 *
 * @author fzhang
 * @date 2020-11-01
 */
public class LogbackTest {

    private static final Logger LOG = LoggerFactory.getLogger(LogbackTest.class);
    private static final Logger LOG1 = LoggerFactory.getLogger("oneInfo");
    private static final Logger LOG2 = LoggerFactory.getLogger("twoInfo");

    public static void main(String[] args) {
        test();
    }

    private static void test() {

        LOG.debug("主程序的debug");
        LOG.info("主程序的info");
        LOG.warn("主程序的warn");
        LOG.error("主程序的error");

        LOG1.debug("oneInfo的debug");
        LOG1.info("oneInfo的info");
        LOG1.warn("oneInfo的warn");
        LOG1.error("oneInfo的error");

        LOG2.debug("twoInfo的debug");
        LOG2.info("twoInfo的info");
        LOG2.warn("twoInfo的warn");
        LOG2.error("twoInfo的error");
    }
}