package Tencent;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/26 20:34
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int times=in.nextInt();
        int nums=0;
        String temp=null;
        int tempnum=0;
        for(int i=0;i<times;i++){
            nums=in.nextInt();
            for(int j=0;j<nums;j++){
                temp=in.next();
                if(temp.equals("PUSH")) {
                    tempnum = in.nextInt();
                    push(tempnum);
                }else {
                    operation(temp);
                }
            }
        }
    }
    public static void operation(String temp){
        if(temp.equals("TOP")) {
            top();
        }else if(temp.equals("POP")){
            pop();
        }else if(temp.equals("SIZE")){
            size();
        }else if(temp.equals("CLEAR")){
            clear();
        }
    }
    private static ArrayList<Integer> arrayList=new ArrayList<>();
    public static void push(int a){
        arrayList.add(a);
    }
    public static void top(){
        int a=arrayList.size()>0?arrayList.get(0):-1;
        System.out.println(a);
    }
    public static void pop(){
        if(arrayList.size()>0){
             arrayList.remove(0);
        }else {
            System.out.println(-1);

        }
    }
    public static void size(){
        System.out.println(arrayList.size());
    }
    public static void clear(){
        arrayList.clear();
    }


}
