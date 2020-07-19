package ThreadJava;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/20 18:46
 */
public class Tools {
    public static ThreadLocal t1=new ThreadLocal();

    public static void main(String[] args) {
        try {
            ThreadA a=new ThreadA();
            ThreadB b=new ThreadB();
            a.start();
            b.start();
            for(int i=0;i<100;i++){
                Tools.t1.set("Main"+(i+1));
                System.out.println("Main get Value="+
                        Tools.t1.get());
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
