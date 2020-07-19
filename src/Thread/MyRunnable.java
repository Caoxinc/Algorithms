package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/1 21:58
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("This is my thread by Runnable" );
    }

    public static void main(String[] args) {
        Runnable mr=new MyRunnable();
        Thread thread=new Thread(mr);
        thread.start();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.submit(new MyRunnable());

    }
}
