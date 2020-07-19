package Tencent;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/26 21:26
 */
public class Main3 {
    public static void main(String[] args) {
        //System.out.println(new Main3().distance(0,0,1,1));
       // System.out.println(String.format("%.3f",0.33333));
        Scanner sc=new Scanner(System.in);
        int nums=sc.nextInt();
        while (nums-->0) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i][0] = sc.nextInt();
                b[i][1] = sc.nextInt();
            }
            double dis = new Main3().findMinDis(a, b);
            System.out.println(String.format("%.3f", dis));
        }



    }
    public double findMinDis(int[][]a,int[][]b){
        double mindis=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                double dis=distance(a[i][0],a[i][1],b[j][0],b[j][1]);
                //System.out.print( dis +" ");
                mindis=Math.min(dis,mindis);
            }
        }
        return mindis;


    }

    public double distance(int x1,int y1,int x2,int y2){
        double ans=0;
        double d1=Math.pow(x1-x2,2);
        double d2=Math.pow(y1-y2,2);
        ans=Math.sqrt(d1+d2);
        return ans;
    }

}
