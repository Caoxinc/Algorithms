package ThreadJava;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/20 18:45
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for(int i=0;i<100;i++){
                Tools.t1.set("ThreadA"+(i+1));
                System.out.println("ThreadA get Value"+
                        Tools.t1.get());
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
