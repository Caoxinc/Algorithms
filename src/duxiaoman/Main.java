package duxiaoman;

import java.util.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/20 16:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

       /* int n=0,m=0,a=0,b=0;
        n=sc.nextInt();
        m=sc.nextInt();
        a=sc.nextInt();
        b=sc.nextInt();
        int[][]nums=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j]=(i+1)*(j+1);
                nums[i][j]%=10;
                //System.out.print(nums[i][j]+" ");
            }
            //System.out.println();
        }

        int ans=0;
        for(int i=0;i<=n-a;i++){
            for(int j=0;j<=m-b;j++){
                ans+=findMaxNum(nums,i,j,a,b);
                //System.out.println(ans+ " ");
            }
        }
        System.out.println(ans);*/
       int N=0,A=0,B=0,C=0;
       N=sc.nextInt();
       A=sc.nextInt();
       B=sc.nextInt();
       C=sc.nextInt();
       int[] nums=new int[N];
        Map<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<N;i++){
           nums[i]=sc.nextInt()-1;
           map.put(i,nums[i]);
       }
       //BFS?
        boolean[] booleans=new boolean[N+1];
        Queue<Integer>queue=new LinkedList<>();
        int n=0;booleans[n]=true;
        queue.add(n);
        int money=0;
        while (!queue.isEmpty()){
            int size=queue.size();

            while (size-->0){
                int num=queue.poll();
                if(num==N-1){
                    money+=A;
                    System.out.println(money);
                    break;
                }
                if(map.get(num)==N-1){
                    money+=B;
                    System.out.println(money);
                    break;
                }
                if(map.get(num)==N+1){
                    money+=C;
                    System.out.println(money);
                    break;
                }
                if(booleans[map.get(num)]=true){
                queue.add(map.get(num));
                booleans[map.get(num)]=true;}
            }
        }


    }
    public  static int findMaxNum(int[][]nums,int x,int y,int a,int b){
        int max=Integer.MIN_VALUE;
        for(int i=x;i<x+a;i++ ){
            for(int j=y;j<y+b;j++){
                max=max>nums[i][j]?max:nums[i][j];
            }
        }
        return max;

    }
}
