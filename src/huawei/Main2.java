package huawei;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/22 20:33
 */
public class Main2 {
    public static int n,m;
    public static int s[]=new int[100000];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=9;m=3;
        s=new int[]{0,100, 200, 300 ,400, 500, 600, 700, 800, 900};
        int i,low,high,mid,num,sum;

        low=high=0;
        for( i=1;i<=n;i++){
            low=Math.max(low,s[i]);
            high+=s[i];
        }

        while (low<=high){
            mid=(low+high)>>1;
            num=sum=0;
            for(i=1;i<=n;i++){
                sum+=s[i];
                if(sum>mid){
                    num++;
                    sum=s[i];
                }
            }
            num++;
            if(num>m){
                low=mid+1;
            }else {
                high=mid-1;
            }
            print(m,n,0,low);
        }

    }

    public static void print(int m,int n,int now,int res){
        if(n==0){
            return;
        }
        if(now+s[n]>res||m>n){
            print(m-1,n,0,res);
            System.out.println("/");
        }else {
            print(m,n-1,now+s[n],res);
            System.out.println(s[n]+" ");
        }

    }

}
