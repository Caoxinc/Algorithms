package Sort;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/5/22 22:30
 */
public class Synch {
   public volatile int inc=0;

    synchronized void go() {
        Synch s = new Synch();
        synchronized (this) {
        }
        synchronized (s) {

        }
        synchronized (Synch.class) {
            System.out.println("hi");
        }
    }

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Synch synch = new Synch();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    synch.increase();
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(synch.inc);
    }
}
