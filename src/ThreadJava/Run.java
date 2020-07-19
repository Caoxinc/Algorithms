package ThreadJava;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/20 18:43
 */
public class Run {
    public static ThreadLocal t1=new ThreadLocal();

    public static void main(String[] args) {
        if(t1.get()==null){
            System.out.println("未放过值");
            System.out.println(t1.get());
            t1.set("我的值");

        }
        System.out.println(t1.get());

    }
}
