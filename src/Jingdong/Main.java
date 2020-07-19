package Jingdong;

import java.util.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/18 19:48
 */
public class Main {
    public void checkFaces(int[][]a){
        //2行6列
        //int longs=0,widths=0,highs=0;
       // Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<Integer> all=new ArrayList<>();
        int k1=0,k2=0;
        for(int i=0;i<6;i++){
            k1=a[0][i];
            k2=a[1][i];
            if(list.contains(k1)){
                list.remove((Integer)k1);
            }else list.add(k1);

            if(list.contains(k2)){
                list.remove((Integer)k2);
            }else list.add(k2);

            if(!all.contains(k1)) all.add(k1);
            if(!all.contains(k2)) all.add(k2);
        }
        if(list.size()!=0||all.size()>3){
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println("POSSIBLE");
        }


    }

    public static void main(String[] args) {
        Main m=new Main();
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        List<Integer> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int[][]a={{1235,2584,2584,683,683,2584},{2584,683,1345,1345,1345,683}};
        Arrays.sort(a);
        m.checkFaces(a);
        while (num-->0){
            list.clear();
            ans.clear();
            for(int j=0;j<6;j++){
                int num1=in.nextInt();
                int num2=in.nextInt();

                if(list.contains(num1))list.remove((Integer) num1);
                else list.add(num1);

                if(list.contains(num2)) list.remove((Integer) num2);
                else list.add(num2);

                if(!ans.contains(num1)) ans.add(num1);
                if(!ans.contains(num2)) ans.add(num2);
            }
            if(list.size()==0&&ans.size()<=3&&ans.size()>=1){
                System.out.println("POSSIBLE");
            }else System.out.println("IMPOSSIBLE");
        }
    }
}
