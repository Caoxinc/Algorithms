package Thread1;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/4 16:40
 */
public class   MyRunnable implements Runnable  {
    String[] Info={
            "one",
            "two",
            "three",
            "four"
    };
    public void run() {
        try {
            for(int i=0;i<Info.length;i++){
                System.out.println(Info[i]);
                Thread.sleep(2000);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}

