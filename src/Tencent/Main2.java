package Tencent;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/26 21:00
 */
public class Main2 {
    public static void main(String[] args) {
        //System.out.println(new Main2().fathersEdge(10,5));
        Scanner sc=new Scanner(System.in);
        Main2 m=new Main2();
        int nums=sc.nextInt();
        for(int i=0;i<nums;i++){
            long a=sc.nextLong();
            int b=sc.nextInt();
            System.out.println(m.fathersEdge(a,b));
        }
       // System.out.println(Integer.MAX_VALUE-2<<10);
    }
    public long fathersEdge(long num,int edge){
        if(edge==1)return 1;
        int numedge=findEdge(num);
        if(edge>=numedge)return -1;
        int diff=1;
        diff=diff<<numedge-edge;
        return num/diff;
    }

    public int findEdge(long num){
        int edge=1;
        int temp=1;
        int sum=1;
        while (sum<num){
            temp=temp<<1;
            sum+=temp;
            edge++;
        }
        return edge;
    }

}
