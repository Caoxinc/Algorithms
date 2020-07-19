package Thread1;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/4 17:36
 */
public class Counter {
    private int c=0;
    public synchronized void increment(){
        c++;
    }
    public synchronized void decrement(){
        c--;
    }
    public synchronized int value(){
        return c;
    }

    public static void main(String[] args) {
        Counter c1=new Counter();

        new Thread(new Runnable() {
            @Override
            public void run() {
                c1.increment();
            }
        }).start();
        new Thread((new Runnable() {
            @Override
            public void run() {
                c1.decrement();
            }
        })).start();

        System.out.println("c1 "+c1.value());
    }


}
