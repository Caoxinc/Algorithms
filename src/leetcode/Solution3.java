package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/5/6 16:31
 */
public class Solution3 {
    public List<Set<Integer>> findRelation(int n, int[][]nums){
        List<Set<Integer>> list=new ArrayList<>();
        int a=0,b=0;
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            a=nums[i][0];
            b=nums[i][1];
            if(!existOrNot(list,a)&&!existOrNot(list,b)){
                Set<Integer> temp=new HashSet<>();
                temp.add(a);
                temp.add(b);
                list.add(temp);
            }else {
                for(Set<Integer> temp1:list){
                    if(temp1.contains(a)){
                        temp1.add(b);
                    }
                    if(temp1.contains(b)){
                        temp1.add(a);
                    }
                }
            }

        }

        return list;
    }
    public boolean existOrNot(List<Set<Integer>> list,Integer a){
        boolean sign=false;
        for(Set<Integer>set:list){
            if(set.contains(a)){
                sign=true;
                return sign;
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        int n=10;
        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
        int [][] nums2={{1,2,3}};
        System.out.println(new Solution3().uniquePathsWithObstacles(nums));
    }
    public int rob(int[] nums) {
        int len=nums.length;
        if(len<=0)return 0;
        int[]dp=new int[len];
        if(len==1){

            return nums[0];
        }
        if(len==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }

    public int minPathSum(int[][] grid) {
        int row=grid.length;
        if(row<=0)return 0;
        int colunm=grid[0].length;
        int[][]dp=new int[row][colunm];
        dp[0][0]=grid[0][0];
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<colunm;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<colunm;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[row-1][colunm-1];
    }
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0)return 0;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        if(row<=0)return 0;
        int colunm=obstacleGrid[0].length;
        int[][]dp=new int[row][colunm];
        if(obstacleGrid[0][0]==1)return 0;
        dp[0][0]=1;
        for(int i=1;i<row;i++){
            if(obstacleGrid[i][0]==0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for(int j=1;j<colunm;j++){
            if(obstacleGrid[0][j-1]==0) {
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        int a=0,b=0;
        for(int i=1;i<row;i++){
            for(int j=1;j<colunm;j++){
                a=obstacleGrid[i][j-1];
                b=obstacleGrid[i-1][j];
                if(a==1&&b==1){
                    dp[i][j]=0;
                }else if(a==1){
                    dp[i][j]=dp[i-1][j];
                }else if(b==1){
                    dp[i][j]=dp[i][j-1];
                }else {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }

        return dp[row-1][colunm-1];
    }


}
