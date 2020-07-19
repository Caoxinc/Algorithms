package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/1 22:06
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

        /*(String a,string b)->{
        System.out.println(a.length());
        System.out.println(b.length());
        System.out.println(a.length()-b.length());
    };*/
    public static void main(String[] args)throws ExecutionException,InterruptedException {
        /*MyCallable mc=new MyCallable();
        FutureTask<Integer> ft=new FutureTask<>(mc);
        Thread thread=new Thread(ft);
        thread.start();
        System.out.println(ft.get());*/
        FutureTask<Integer> futureTask=new FutureTask<Integer>(
                (Callable) ()->{
                    System.out.println("aaa");
                    return 5;
                }
        );
        new Thread(futureTask,"有返回值的线程").start();
        try{
            System.out.println("子线程的返回值"+futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println();
    }
}
