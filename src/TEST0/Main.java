package TEST0;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/16 14:21
 */
public class Main {
    public int findNum(int [] a){
        int len=a.length;
        sort(a);
        return a[len/2];
    }
    public void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            boolean sign=false;
            for(int j=a.length-1;j>0;j--){
                if(a[j]>a[j-1]){
                    swap(a,j,j-1);
                }
                sign=true;
            }
            if(sign=false)return;
        }
    }
    public void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        int[]a={1,2,1,1,2,1,1};
        System.out.println(new Main().findNum(a));
    }
}
