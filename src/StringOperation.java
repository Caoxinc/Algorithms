/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/29 9:42
 */
public class StringOperation {
    /*
    获取next数组
    * */
    public int[] get_next(String T){
        int[] next=new int[T.length()];
        int i=0,j=0;
        next[0]=0;
        while(i<T.length()){
            if(j==0||T.charAt(i)==T.charAt(j)){
                ++i;
                ++j;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        StringOperation so=new StringOperation();
        String T="abcdex";
        int[] next= so.get_next(T);
        for(int a:next){
            System.out.print(a);
        }
    }
}
