package Test;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/24 20:08
 */
public class Solution {
    public int minNumOfChange(String str1,String str2){
        if(str1.length()==0||str1.length()!=str2.length())return 0;
        int num1=0;
        int num2=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!= str2.charAt(i)){
                if(str1.charAt(i)=='A'){
                    num1++;
                }else {
                    num2++;
                }
            }
        }
        int max=Math.max(num1,num2);
        /*int min=Math.min(num1,num2);
        int result=(max-min)+min/2;*/
        return max;
    }

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        //String a=null, b=null;
        int a=0,b=0;
        while(cin.hasNext())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            // System.out.println(a + b);
            /*Solution m=new Solution();
            System.out.println(m.minNumOfChange(a,b));*/
            System.out.println(a+b);
        }
        //第一行表示数据行，剩余每行做和
        /*Scanner cin = new Scanner(System.in);
        //String a=null, b=null;
        int a=0,b=0;
        int num=0;
        while(cin.hasNext())
        {
            num=cin.nextInt();
            while(num-->0){
                a = cin.nextInt();
                b = cin.nextInt();
                // System.out.println(a + b);
            *//*Solution m=new Solution();
            System.out.println(m.minNumOfChange(a,b));*//*
                System.out.println(a+b);

            }
        }*/
        /*
输入数据包括多组。
每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
接下来n个正整数,即需要求和的每个正整数。*/
        /*Scanner sc=new Scanner(System.in);
        while(!sc.hasNext("0")){
            int p=sc.nextInt();
            int sum=0;
            for(int i=0;i<p;i++){
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }*/
    }
}
