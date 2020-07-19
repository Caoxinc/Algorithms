package Sort;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/10 16:24
 */
public class Sort {
    public void quickSort1(int[]s,int l,int r){
       /* if (l < r) {
            int x = s[l];
            int i = l, j = r;
            while (i < j) {
                while (i < j && s[j] >= x)
                    j--;//找到第一个比该值小的
                if(i<j) s[i++] = s[j];
                while (i < j && s[i] <= x)
                    i++;//找到第一个比该值大的
                if(i<j) s[j--] = s[i];
            }
            s[i] = x;
            quickSort1(s, l, i - 1);
            quickSort1(s, i + 1, r);
        }*/
        if (l < r) {
            int x = s[l];
            int i = l, j = r;
            while (i < j) {
                while (i < j && s[j] >= x) j--;
                if (i < j) s[i++] = s[j];
                while (i < j && s[i] <= x) i++;
                if (i < j) s[j--] = s[i];

            }
            s[i] = x;
            quickSort1(s, l, i - 1);
            quickSort1(s, i + 1, r);
        }
    }
    public void quickSort(int []a){
        if(a.length<=1) return;
        quickSort1(a,0,a.length-1);
    }
    public static void merSort(int[]arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            merSort(arr,left,mid);
            merSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public  static void mergeSort(int [] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            Merge(arr,left,mid,right);
        }

    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[]temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for(int k2=0;k2<temp.length;k2++){
            arr[k2+left]=temp[k2];
        }
    }


    private static void Merge(int[] arr, int left, int mid, int right) {
        int[]temp=new int[right-left+1];
        int i=left;
        int j=mid;
        int k=0;
        while (i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for(int k2=0;k2<temp.length;k2++){
            arr[left+k2]=temp[k2];
        }
    }

    public static void main(String[] args) {
        int[]a={2,3,7,9,2};
        Sort sort=new Sort();
        sort.mergeSort(a,0,a.length-1);
        for(int num:a){
            System.out.print(num+" ");
        }
    }
}
