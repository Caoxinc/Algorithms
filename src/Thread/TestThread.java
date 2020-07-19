package Thread;

import java.util.concurrent.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/1 22:03
 */
public class TestThread {
    public static void main(String[] args)throws ExecutionException,InterruptedException {

        ExecutorService executor= Executors.newFixedThreadPool(3);
        try {
            //1\创建runnable调度等待任务执行完毕
            Future<?> runnable1=executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("runnable1 running");
                }
            });
            System.out.println("runnable1:"+runnable1.get());



            //2Callable通过Future返回结果
            Future<String> future1=executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "result=task1";
                }
            });
            System.out.println("task1 "+future1.get());


            //3
            Future<String> future2=executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        while (true){
                            System.out.println("task2 funning");
                            Thread.sleep(50);
                        }
                    }catch (InterruptedException e){
                        System.out.println("Interrupted task2.");
                    }
                    return "tast2= false";
                }
            });
            Thread.sleep(10);
            System.out.println("task2 cancel:"+ future2.cancel(true));

        }catch (Exception e){
            System.out.println(e.toString());


        }
    }
}
