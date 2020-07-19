package Thread;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/1 22:12
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                int time=(int)(Math.random()*1000);
                //Thread.sleep(time);
                System.out.println("run=="+Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
       /* System.out.println(Thread.currentThread().getName());
        Thread thread=new MyThread();
        thread.start();*/
        try {
            MyThread myThread=new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for(int i=0;i<10;i++){
                int time=(int)(Math.random()*1000);
                //Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       /* new Thread(){
            public void run(){
                System.out.println("anoymous");
            }
        }.start();
        new Thread(
                ()-> System.out.println("lamada")
        ).start();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };
        new Thread(new Runnable() {
                 public void run(){
                     System.out.println("nothing");
                 }
        }).start();*/

    }

}
