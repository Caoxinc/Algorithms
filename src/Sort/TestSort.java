package Sort;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/3/14 12:52
 */
public class TestSort {
    public void insertSort(int[] nums){
        int temp;
        for(int i=1;i<nums.length;i++){
            temp = nums[i];
            int j;
            for(j=i;j>0&&temp<nums[j-1];j--){


                nums[j]=nums[j-1];

            }
            nums[j]=temp;
        }
    }
    public void midInsertSort(int[] nums){
        int temp;
        for(int i=1;i<nums.length;i++){
            temp = nums[i];
            int j;
            int low=0;
            int high=i-1;
            int mid;
            while (low<=high){
                mid=(low+high)/2;
                if(nums[mid]>temp){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }

            for(j=i-1;j>=high+1;j--){
                nums[j+1]=nums[j];
            }
            nums[high+1]=temp;
        }
    }
    public void pumpSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            boolean flag=false;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    exch(nums,j,j-1);
                    flag= true;
                }
            }
            if(flag==false){
                return;
            }
        }
    }
    public void exch(int[] nums,int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;

    }
    public void selectSort(int[] nums){
        int min;
        for(int i=0;i<nums.length-1;i++){
            min=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            if(i!=min){
                exch(nums,i,min);
            }
        }
    }
    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
   /* private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }*/
    /*public void partitionSort(int[] nums,int low,int high){
        if(low<high){
            int j=Partition(nums,low,high);
            partitionSort(nums,low,j-1);
            partitionSort(nums,j+1,high);
        }
    }
    public int Partition(int[] nums,int low,int high){
        int pivot=nums[low];
        while (low<high){
            while (low<high&&nums[high]>pivot)
                high--;
            //exch(nums,low,high);
            nums[low]=nums[high];
            while (low<high&&nums[low]<pivot)
                low++;
            //exch(nums,low,high);
            nums[high]=nums[low];
        }
        return low;

    }*/
    public void shellSort(int[] nums){
        int len=nums.length;
        int temp;
        for(int dk=len/2;dk>=1;dk/=2){
            for(int i=dk+1;i<len;++i)
                if(nums[i]<nums[i-dk]){
                 temp=nums[i];
                 for(int j=i-dk;j>0&&temp<nums[j];j-=dk)
                     nums[j+dk]=nums[j];
                }
        }
    }

    public static void main(String[] args) {
        TestSort sort=new TestSort();
        int[] nums={2,3,7,1,8,9};
        sort.insertSort(nums);
        for(int a:nums){
            System.out.print(a+" ");
        }

    }
}
