package leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/29 20:44
 */

public class Main{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int times=s.nextInt();
        int[] nums=new int[n];
        HashMap<Integer,Integer>map=new HashMap<>();
        int a=0;
        int max=0;
        int min=0;
        for(int i=0;i<n;i++){
            a=s.nextInt();
            max=Math.max(max,a);
            min=Math.min(min,a);
            nums[i]=a;
            if(!map.containsKey(a)){
                map.put(a,1);
            }else {
                map.put(a,map.get(a)+1);
            }
        }
        if(map.containsKey(times)){
            System.out.println(0);
        }

        }
/*for(int i=0;i<2*n;i++){
            nums[i]=s.nextInt();
        }
        int res=0;
        for(int i=0;i<nums.length;i+=2){
            int temp=nums[i];
            if(nums[i+1]==(temp^1))continue;
                res++;
                for(int j=i+1;j<nums.length;++j){
                    if(nums[j]==(temp^1)){
                        nums[j]=nums[i+1];
                        nums[i+1]=temp^1;
                        break;
                    }
                }
        }
        System.out.println(res);*/

    public static int maxnum(int[][]nums){
        int[]dp=new int[nums.length+1];
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.max(dp[j],dp[j+1])+nums[i][j];
            }
        }
        return dp[0];

    }

    /*public int maxCoins(int[][] nums){
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(nums[i][j]>=0){
                    res=Math.max(res,dfs(i,j,nums));
                }
            }
        }
        return res;
    }
    public int dfs(int i,int j,int[][]nums){
        if(i<0||j<0||i>=nums.length||j>=nums[i].length||nums[i][j]<0){
            return 0;
        }
        int num=nums[i][j];
        //nums[i][j]=-1;
        num+=dfs(i+1,j+1,nums);
        num+=dfs(i+1,j-1,nums);
        return num;
    }*/


    }


