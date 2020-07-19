package pingduoduo;

import java.util.ArrayList;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/6/2 19:15
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().printNum(2,1000000000));
    }
    private ArrayList<Integer> list=new ArrayList<>();
    public int printNum(int n,int k){
        if (n<0||k<=0)return -1;
        int num=0;
        int nums=0;
        for(int i=1;i<n;i++){
            if(n%i!=0){
                nums++;
                list.add(i);
            }
        }
        //System.out.println(list);
        if(k<=list.size())return list.get(k-1);
        else return (k-nums)+n;

    }
}
