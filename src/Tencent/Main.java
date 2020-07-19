package Tencent;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/26 20:04
 */
public class Main {
    private static Stack<Integer>stack1=new Stack<>();
    private static Stack<Integer>stack2=new Stack<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String temp;
        int a=0;
        for(int i=0;i<n;i++){
            temp=sc.next();
            if(temp.equals("add")){
                a=sc.nextInt();
                add(a);
            }else {
                if(temp.equals("poll"))
                poll();
                else {
                    if(temp.equals("peek")){
                        System.out.println(peek());
                    }
                }
            }
        }
    }
    public static void add(int a){
        stack1.push(a);
    }
    public static int poll(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }
    public static int peek(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }else {
            return stack2.peek();
        }
    }


}
