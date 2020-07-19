package QuickHand;

import java.util.*;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/12 16:05
 */
public class Main {

    public static void main(String[] args) {
        Main m=new Main();
        /*Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();*/
        char[][]pos={{'*','.','*','*','.'},{'*','.','*','*','*'},{'*','.','*','*','.'}};
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        //System.out.println(m.GetMaxStaffs(pos));
        /*int[] a={1,2,3};
        m.findAllLine(new ArrayList<>(),a);
        for(ArrayList<Integer> list:m.alllists){
            System.out.println(list);
        }*/
        //m.printNums("))()())(()");
    }

    public int findWinnerBetween(int[]a,int i,int j){
        if (a[i] < a[j]) {
            return j;
        }else {
            return i;
        }
    }
    int[] num={0};
    public int GetMaxStaffs (char[][] pos) {
        // write code here
        if(pos==null||pos.length==0)return 0;
        if(pos[0].length==0)return 0;
        int[][]direction={{-1,0},{1,0},{0,-1},{0,1}};
        int max=Integer.MIN_VALUE;
        for( int i=0;i<pos.length;i++){
            for(int j=0;j<pos[0].length;j++){
                int a=findMaxNums(pos,i,j,num,direction);
                max=Math.max(a,max);
            }
        }
        return max;
    }
    public int findMaxNums(char[][]pos,int row,int column,int[]num,int[][]direction){
        if(row<0||row>=pos.length||column<0||column>=pos[0].length
                ||pos[row][column]!='.'){
            return -1;
        }
        if(pos[row][column]=='.') {
            pos[row][column]='0';
            set(pos,row,column,direction);
            num[0]++;
        }

        for(int[]a:direction){
            int x=a[0],y=a[1];
            findMaxNums(pos,row+x,column+y,num,direction);
        }
        return num[0];

    }
    public void set(char[][]pos,int row,int column,int[][]direction){
        for(int[]a:direction){
            int x=row+a[0],y=column+a[1];
            if(x>=0&&x<pos.length&&y>=0&&y<pos.length){
                pos[x][y]='*';
            }

        }
    }

    public int[] WaitInLine (int[] a, int[] b) {
        // write code here
        Map<Integer,Integer>mapa=new LinkedHashMap<>();
        Map<Integer,Integer>mapb=new LinkedHashMap<>();
        int min=0;
        int len=a.length;
        int[] begin=new int[len];
        for(int i=0;i<len;i++){
            mapa.put(i,a[i]);
            mapb.put(i,b[i]);
            min+=a[i]*(i-1)+b[i]*(len-i);
            begin[i]=i;
        }
        int [] ans=new int[len];
        ArrayList<Integer>list=new ArrayList<>();
        findAllLine(new ArrayList<>(),begin);
        int sign=0;
        for(int j=0;j<alllists.size();j++){
            ArrayList<Integer>temp=alllists.get(j);
            int sum=0;
            for(int i=0;i<temp.size();i++){
                sum+=mapa.get(i)*(i-1)+(temp.size()-i)*mapb.get(i);
            }
            if(sum<min){
                sign=j;
                min=sum;
            }
        }
        int indx=0;
        for(Integer nums:alllists.get(sign)){
            begin[indx++]=nums;
        }
        return begin;
    }
    public ArrayList<ArrayList<Integer>>alllists=new ArrayList<>();
    public void findAllLine(ArrayList<Integer>list,int[]a){
        if(list.size()==a.length){
            alllists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(!list.contains(a[i])){
                list.add(a[i]);
                findAllLine(list,a);
                list.remove(list.size()-1);
            }
        }
    }
    public void dfs(){

    }
    public void printNums(String s){
        Stack<Character>stack=new Stack<>();
        ArrayList<Character>list=new ArrayList<>();
        for(char a:s.toCharArray()){
            if(a=='('||a==')'){
                list.add(a);
            }
        }
        int numleft=0,numright=0,num=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==')'){//右括号
                if(stack.isEmpty()) {
                    numright++;
                }else {
                    stack.pop();
                    num++;
                }
            }else {
                stack.push(list.get(i));
            }
        }
        numleft=stack.size();
        System.out.print(num+" ");
        System.out.print(numleft+" ");
        System.out.println(numright);
    }
}
