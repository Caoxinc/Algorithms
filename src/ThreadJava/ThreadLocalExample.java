package ThreadJava;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/20 18:59
 */
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter=
            ThreadLocal.withInitial(()->new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args)throws InterruptedException {
        ThreadLocalExample obj=new ThreadLocalExample();
        for(int i=0;i<10;i++){
            Thread t=new Thread(obj,""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

    }
    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+
                "default Formatter = "+formatter.get().toPattern());
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+
                "default Formatter = "+formatter.get().toPattern());
    }
}
