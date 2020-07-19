package Thread1;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/4 16:29
 */
public class SleepMessages {
    public static void main(String[] args) {
        String[] Info={
                "one",
                "two",
                "three",
                "four"
        };
        try {
            new Thread(new MyRunnable()
            ).start() ;
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("other Thread");
                }
            }).start();*/
            if(Thread.interrupted()){
                throw new InterruptedException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
