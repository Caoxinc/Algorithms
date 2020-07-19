package ThreadJava;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/19 16:30
 */
public class MyThread extends Thread {

    private int count=5;
    private long i=0;
    public long getI(){
        return i;
    }
    public void setI(long i){
        this.i=i;
    }


    @Override
    synchronized public void run() {
            while(true){
                i++;
            }

    }

    public static void main(String[] args) {
        /*MyThread a=new MyThread("A");
        MyThread b=new MyThread("B");
        MyThread c=new MyThread("C");
        a.start();
        b.start();
        c.start();*/
        MyThread myThread=new MyThread();
        myThread.setName("MyThread");
        Thread a=new Thread(myThread,"A");
        Thread b=new Thread(myThread,"B");
        Thread c=new Thread(myThread,"C");
        Thread d=new Thread(myThread,"D");
        Thread e=new Thread(myThread,"E");

        a.start();
        System.out.println(Thread.currentThread().getName());
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
