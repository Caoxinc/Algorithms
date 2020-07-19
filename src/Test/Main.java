package Test;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/24 20:47
 */
public class Main {
    public double changeOfA(int n,int m){
        int sum=n+m;
        int num=sum/3+1;
        double res=0;
        double temp=0;
        for(int i=1;i<=num;i++){
            if(n==1) {
                temp = n / sum;
                n--;
                sum--;
                res += temp;
            }else {
                res+=resOfEveryTimes(n-1,m,sum-2);
            }
        }
        return res;
    }
    public double resOfEveryTimes(int n,int m,int sum){

        return 0;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a=0, b=0;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(new Main().changeOfA(a,b));
        }
    }
}
