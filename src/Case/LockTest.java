/**
 * Created by geekieo on 2018/2/10.
 */
public class LockTest {
    public static void main(String[] args) {
        Lock fatMan = new Lock("food");
        Lock thinMan = new Lock("money");
        new Thread(fatMan, "Fatter").start();
        new Thread(thinMan, "Thinner").start();
    }
}

// Lock thread
class Lock implements Runnable {
    static Object food = new Object();
    static Object money = new Object();
    private String valuables;

    public Lock(String valuables) {
        this.valuables = valuables;
    }

    public void run() {
        if (valuables == "food") {
            while (true) {
                synchronized (food) {// synchronized同步锁，锁住对象，只能一条线程用
                    System.out.println(Thread.currentThread().getName()
                            + "---get---food!");
                    synchronized (money) {
                        System.out.println(Thread.currentThread().getName()
                                + "---get---money!");
                    }
                }
            }
        } else if (valuables == "money") {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                synchronized (money) {
                    System.out.println(Thread.currentThread().getName()
                            + "---get---money!");
                    synchronized (food) {
                        System.out.println(Thread.currentThread().getName()
                                + "---get---food!");
                    }
                }
            }
        }
    }
}
