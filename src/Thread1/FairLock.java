package Thread1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/5/29 22:03
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock=new ReentrantLock(true);
    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                condition.await();
                //System.out.println(Thread.currentThread().getName()+"获得锁");
                System.out.println("Thread is going on");

            }catch (InterruptedException e){
                e.printStackTrace();

            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLock r1=new FairLock();
        Thread t1=new Thread(r1,"Thread_t1");
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();;
        lock.unlock();
    }
}
