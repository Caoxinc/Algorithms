package Thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/2 11:03
 */
public class InterruptExanple {
    private static class MyThread1 extends Thread{
        @Override
        public void run() {
            try {
                //Thread.sleep(1000);
                System.out.println("Thread RUN");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static class MyThread2 extends Thread{
        public void run(){
            while (!interrupted()){
                System.out.println("not interrupted");
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        /*Thread thread=new MyThread2();
        thread.start();*/
        //thread.interrupt();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()->{
            try{
                Thread.sleep(1000);
                System.out.println("Thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }
    ArrayList arrayList=new ArrayList();
}



