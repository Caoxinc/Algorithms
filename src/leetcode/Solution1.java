package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/29 19:50
 */
public class Solution1 {
    public int gcd(int a ,int b){
        return b==0?a:gcd(b,a%b);
    }
    public int lcm(int a,int b){
        /*int temp;
        if(a<b){
            temp=a;
            a=b;
            b=temp;
        }
        int a1=a;
        int b1=b;
        int r=1;
        while (r!=0){
            r=a%b;
            a=b;
            b=r;
        }
        *//*System.out.println(a);
        System.out.println(a1*b1/a);*//*
        return a1*b1/a;*/
        return a*b/gcd(a,b);
    }
    public int findMaxValue(int n){
        if(n<2)return 0;
        /*if(n<2)return 0;
        int max=Integer.MIN_VALUE;
        for(int i=2;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(lcm(i,j)-gcd(i,j)>max){
                    max=lcm(i,j)-gcd(i,j);
                }
            }
        }
        return max;*/
        return lcm(n,n-1)-gcd(n,n-1);
    }
    public int minNum(int n,int[] num){
        if(n<2||num.length==0)return 0;
        Arrays.sort(num);
        int len=num.length;
        if(num[len-1]<n)return 0;
        int k=0;
        while(!(num[len-1]<n)){
            for(int i=0;i<len-1;i++){
                num[i]++;
            }
            num[len-1]-=n;
            k++;
            Arrays.sort(num);
        }
        return k;
    }
    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        /*System.out.println(s1.gcd(12,4));
        System.out.println(s1.lcm(12,4));*/

        Scanner in = new Scanner(System.in);
        int a=0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
             a = in.nextInt();
            int[] nums=new int[a];
            for(int i=0;i<a;i++){
                nums[i]=in.nextInt();
            }

            System.out.println(s1.minNum(a,nums));

        }
        /*int num=3;
        int[] nums={1,0,3};
        System.out.println(s1.minNum(num,nums));*/

    }
}
