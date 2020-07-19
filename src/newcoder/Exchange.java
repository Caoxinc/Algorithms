package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/24 21:37
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
         Arrays.sort(penny);
         findWays(penny,aim,0);
        return ans;
    }
    private List<Integer>temp=new ArrayList<>();
    private int ans=0;
    public void findWays(int[] penny,int num,int begin){
        if(num<0){
            return;
        }
        if(num==0){
            ans++;
            System.out.println(temp);
            //temp.clear();
            return;
        }
        for(int i=begin;i<penny.length;i++){

            int addnum=penny[i];

            temp.add(addnum);
            findWays(penny,num-addnum,i);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]a={1,2,4};
        Exchange ex=new Exchange();
        System.out.println(ex.countWays(a,3,3));
    }
}
