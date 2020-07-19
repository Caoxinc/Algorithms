package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/2/29 17:03
 */
public class Animal {

    private  String mao="小菊";
    private static int num=0;
    /*public Animal() {
        System.out.println("constructor animal");
        num++;
    }*/
    {
        System.out.println("block");
        num++;
    }

    static {
        System.out.println("stack block");
        num++;
    }
    public void valueOfNum(){
        System.out.println(num);
    }
    public void sing(){
        System.out.println("I am animal!");
    }
}
class Dog extends Animal{
    public  Dog(){
        super();
    }
    public void sing(){
        System.out.println("我是狗！");
    }
}
class Cat extends Animal{
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String sing(String a){
        System.out.println("我是"+a+"猫");
        return a+"猫";
    }
}


class Test{
    public static void main(String[] args)throws IOException {

        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(list.size());
        Integer[]a={1,2,3,4,5,6,7,8,9,10,11};
        list.addAll(Arrays.asList(a));
        System.out.println(list.size());
    }
}