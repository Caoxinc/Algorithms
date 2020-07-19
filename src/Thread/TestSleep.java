package Thread;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/14 9:14
 */
public class TestSleep implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("run begin" + Thread.currentThread().getName() +  System.currentTimeMillis());
            for(int i=0;i<100000;i++){
                i+=i;
            }
            System.out.println("run end" + Thread.currentThread().getName() + System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t=new Thread(new TestSleep());
        System.out.println("begin" + System.currentTimeMillis());
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println("end" + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName()+Thread.interrupted());
    }
}
