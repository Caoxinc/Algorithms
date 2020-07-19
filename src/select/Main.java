package select;

import java.util.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/9 19:09
 */
public class Main {

    public void printDay(long x,String time,long n){
        char[] chars=time.toCharArray();
        long hoursnow=(chars[0]-'0')*10+(chars[1]-'0');
        long minutesnow=(chars[3]-'0')*10+(chars[4]-'0');
        n=n%(60*24*7);//返回时间
        long m=60*24*7-n;//在此基础上相加
        long mins=minutesnow+m%(60*24);
        long days=n/60/24;
        long hours=n/60%24;
        long minutes=n%60;

        long outdays=x>=days?x-days:x+7-days;//归到该天在进行时分计算
        if(minutesnow<minutes){
            hoursnow--;
            minutesnow=minutesnow+60-minutes;
        }else minutesnow-=minutes;
        if(hoursnow<hours){
            outdays=outdays==1?7:outdays-1;
            hoursnow=hoursnow+24-hours;
        }else hoursnow-=hours;
        System.out.println(outdays);
        String out=""+hoursnow+":"+minutesnow;
        System.out.println(out);
    }
    public void printNumOfWinners(int n,int[]begin,int[]end){
        int num=0;
        Map<Integer,Integer> map=new LinkedHashMap<>();//存储编号与起始位
        for(int i=0;i<n;i++){
            map.put(begin[i],i);//K:编号; V：起始位置
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.get(end[i])>map.get(end[j])){
                    num++;
                    break;
                }
            }
        }
        System.out.println(num);
    }
    public void printMinNum(int n,int days){
        int num=0;
        for(int i=n/days;i<=n;i++){
            if(successOrNot(i,days,n)){
                num=i;
                break;
            }
        }
        System.out.println(num);
    }
    public boolean successOrNot(int x,int days,int n){
        //x为最初的bug数
        //int[] bugs=new int[days];
        int nums=0;
        for(int i=0;i<days;i++){
            /*bugs[i]=(int) Math.floor(x/Math.pow(days,i));
            nums+=bugs[i];*/
            nums+=(int) Math.floor(x/Math.pow(days,i));
        }
        return nums>=n;
    }
    public void printNumOfWays(int n,Node S){
        List<Integer> list=new LinkedList<>();
        if(n<=1) System.out.println(0);
        if(n==2) System.out.println(3);
        dfs(S,S,list,n);
        System.out.println(list.size());
    }
    public void dfs(Node begin,Node end,List<Integer>list,int n){
        if(n==0&&begin.val!="S")return;
        if(n==0&&begin.val=="S"){
            list.add(1);
            return;
        }
        dfs(begin.left,end,list,n-1);
        dfs(begin.mid,end,list,n-1);
        dfs(begin.right,end,list,n-1);
    }
    public static void main(String[] args) {

        Node S=new Node("S");
        Node A=new Node("A");
        Node B=new Node("B");
        Node C=new Node("C");

        S.left=A;S.mid=C;S.right=B;
        A.left=C;A.mid=B;A.right=S;
        B.left=S;B.mid=A;B.right=C;
        C.left=B;C.mid=S;C.right=A;

        Main m = new Main();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        m.printNumOfWays(n,S);
        //m.printDay(3,"02:10",200000);
       /* Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        m.printMinNum(n,k);*/
        /*int n=sc.nextInt();
        int[] begin=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            begin[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            end[i]=sc.nextInt();
        }*/
        /*long x =0;//个数
        String time ="";
        long n =0;

            x = sc.nextLong();
            time = sc.next();
            n = sc.nextLong();

        m.printDay(x, time, n);*/
        /*int n=5;
        int[] begin={5,3,1,4,2};
        int[] end={2,4,5,1,3};*/
        //m.printNumOfWinners(n,begin,end);
        //System.out.println(Math.ceil(2.3));
    }
}
