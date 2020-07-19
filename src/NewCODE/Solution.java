package NewCODE;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/11 17:14
 */
public class Solution {
    public static void main(String[] args) {
       /*
        Scanner sc=new Scanner(System.in);
        int nums=sc.nextInt();*/
        /*Solution s1=new Solution();
        int[] res={2,1,3,4,5};
            System.out.println(s1.operation(res));
            StringBuffer stringBuffer=new StringBuffer(1);
        System.out.println(stringBuffer.length());
            StringBuffer stringBuffer1=new StringBuffer("1");
        System.out.println(stringBuffer1.length());*/
        System.out.println(new Solution().reverse(-123));
    }
    public int operation(int[]nums){
        int right= nums.length-1;
        int left=0;
        int temp=0;
        boolean sign1=false;
        boolean sign2=false;
        for(int i=right;i>=0;i--){
            temp=nums[i];
            for(int j=right-1;j>=0;j--){
                if(nums[j]>temp){
                    right=i;
                    sign1=true;
                    break;
                }
            }
            if(sign1)break;
        }
        if(sign1==false)return 0;
        for(int i=left;i<nums.length;i++){
            temp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<temp){
                    left=i;
                    sign2=true;
                    break;
                }
            }
            if(sign2)break;

        }
        if(sign2==false)return 0;
        return right-left+1;
    }
    public int leftNum(){
        int num=0;
        for( num=1000;num<=2000;num++){
            int pro=num;
            int count=0;
            for(int i=0;i<5;i++){
                int a;
                if(pro%4==0){
                    a=pro/4*5;
                    count++;
                    pro=a-1;
                }else {
                    num++;
                    break;
                }
                if(count==4){
                    return num;
                }
            }
        }
        return num;
    }

    /*
    *第一题，测试用例
    * int[][]a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(s1.Find(5,a));
        * int[][]a={{}};
    * */
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length<1)return false;
        int rows=array.length;
        int column=array[0].length;
        if(rows==0||column==0)return false;
        int i=rows-1;
        int j=0;
        while (i>=0&&j<=column-1){
            if(array[i][j]>target){
                i--;

            }else j++;
            if(i<0||j>column-1)return false;
            if(array[i][j]==target)return true;
        }
        return false;
    }
    /*第二题
    *
    * */
    public String replaceSpace(StringBuffer str) {
        if(str==null)return "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    /*第三题
    * */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode p0=new ListNode(-1);

        ListNode p1=listNode;
        if(listNode==null||listNode.next==null){
            list.add(listNode.val);
            return list;
        }
        ListNode temp;
        while (p1!=null){
            temp=p1.next;
            p1.next=p0.next;
            p0.next=p1;
            p1=temp;
        }
        p1=p0.next;
        while (p1!=null){
            list.add(p1.val);
        }
        return list;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if(listNode!=null) {
            list.addAll(printListFromTailToHead(listNode.next));
            list.add(listNode.val);
        }
        return list;

    }
    public int reverse(int x) {
        long out=0;
        int temp=0;
        while (x!=0) {
            temp=x%10;
            x /= 10;
            out = out * 10 + temp;
        }
        if(out>Integer.MAX_VALUE||out<Integer.MIN_VALUE){
            return 0;
        }
        return (int)out;

    }
    public int cuttingRope1(int n) {
        if(n==1)return 0;
        if(n==2)return 1;
        if(n==3)return 2;

        BigInteger[] dp=new BigInteger[n+1];
        dp[1]=new BigInteger("1");//因为多于两段，所以这里置为1
        dp[2]=new BigInteger("2");
        dp[3]=new BigInteger("3");
        for(int i=4;i<=n;i++){
            dp[i]=new BigInteger("0");//初值
            //求max（dp[i],dp[i-k]*dp[k]）
            for(int j=1;j<=i/2;j++){
                dp[i]=dp[i].max(dp[j].multiply(dp[i-j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();

    }
    public int cuttingRope(int n) {
        if(n<=1)return 0;
        if(n==2)return 1;
        if(n==3)return 2;
        if(n==4)return 4;
        if(n==5)return 6;

        int a=n%3;
        int b=n/3;
        BigInteger temp=new BigInteger("0");
        BigInteger cnt=new BigInteger("3");
        if(a==0){
            temp=cnt.pow(b);
        }else if(a==1) {
            temp=cnt.pow(b-1).multiply(new BigInteger("4"));
        }else {
            temp=cnt.pow(b-1).multiply(new BigInteger("6"));
        }
        return temp.mod(new BigInteger("1000000007")).intValue();
    }
}
