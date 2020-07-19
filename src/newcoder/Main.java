package newcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/24 21:23
 */
public class Main {
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        ArrayList arrayList1=new ArrayList(11);
        arrayList1.add(1);
        ArrayList arrayList2=new  ArrayList(8);
        arrayList2.add(1);
       /* System.out.println("arraylist:  "+arrayList.size());
        System.out.println("arraylist1:  "+arrayList1.size());
        System.out.println("arraylist2:  "+arrayList2.size());*/
        int[]a={1,2,3};
        int[]b={4,5,6};
        int[]c={7,8,9};
        int[]e= Arrays.copyOf(a,a.length);
        int[][] d=new int[][]{a,b,c};
        for(int[] temp:d){
            for(int num:temp){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
