package Tencent;

import java.util.Scanner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/5/20 14:47
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        int target=sc.nextInt();
        //String s1=sc.next();
       String[]arr=s1.split(",");
       int[] nums=new int[arr.length];
       for(int i=0;i<nums.length;i++){
           nums[i]=Integer.parseInt(arr[i]);
       }
       int[]out=new Solution().twoSum(nums,target);
        /*int[]nums={1,3,5,8 };
        int target=9;
        int[]out=new Solution().twoSum(nums,target);*/
        //System.out.println(out[0]+" "+out[1]);
    }
    public int [] twoSum(int[]nums,int target){
        int [] out=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    out[0]=i;
                    out[1]=j;
                    return out;
                }
            }
        }
        return out;
    }
    public int lengthOfLastWort(String s){
        s=s.trim();
        int start=s.lastIndexOf(" ")+1;
        return s.substring(start).length();
    }
}
