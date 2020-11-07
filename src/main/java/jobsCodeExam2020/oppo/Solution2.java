package jobsCodeExam2020.oppo;

/**
 * 三个线程循环打印 ABC
 *
 * @author 13585
 * @date 2020-09-23
 */
public class Solution2 {
    public static class Printer implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private Printer(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            while (true) {//多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                synchronized (prev) {    // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);

                        self.notifyAll();// 先释放 self，唤醒其他线程竞争self锁
                    }
                    try {
                        prev.wait();     // 再释放 prev，休眠等待唤醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Printer pa = new Printer("A", c, a);
        Printer pb = new Printer("B", a, b);
        Printer pc = new Printer("C", b, c);


        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}