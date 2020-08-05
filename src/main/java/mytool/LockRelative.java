package mytool;

/**
 * java并发与多线程中锁的相关概念
 *
 * @author fzhang
 * @date 2020-08-04
 */
public class LockRelative {

    public static volatile long count = 0L;

    public static final int NUMBER = 100000;

    public static void main(String[] args) {
        CountNum countNum = new CountNum();
        Thread subtractThread = new Thread(countNum);
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (LockRelative.class) {
                count += 1;
            }
            System.out.println("main = " + count);
        }

        while (subtractThread.isAlive()) {

        }

        System.out.println("count = " + count);
    }

    private static class CountNum implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                // 体会此处synchronized关键字的必要性
                synchronized (LockRelative.class) {
                    count -= 1;
                }
                System.out.println("subThread = " + count);
            }
        }
    }
}
