import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用 log 记录运行信息
 *
 * @author fzhang
 * @date 2020-11-01
 */
public class LogTest {

    private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LOG.trace("LOG trace");
        LOG.debug("LOG debug");
        LOG.info("LOG info");
        LOG.warn("LOG warn");
        LOG.error("LOG error");
    }
}
