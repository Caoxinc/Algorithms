package leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //初始化容器
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        //遍历数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];//取值
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;//找出代表哪个格

                    //keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);//hashmap检查是否已有数据时使用
                    columns[i].put(n, columns[i].getOrDefault(n, 0) + 1);
                    boxes[i].put(n, boxes[i].getOrDefault(n, 0) + 1);

                    //check values
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    //组合总和
    private List<List<Integer>> list = new LinkedList<>();

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;


    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            res.add(new ArrayList<>(pre));
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i+1, pre);
            pre.pop();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());//为啥解释一下
        //lists.add(list);
        int len = list.size();
        if (len == 0) return lists;
        if (len == 1) {
            lists.add(list);
            return lists;
        }
        int length = 1;
        while (len >= 1) {
            length *= len--;
        }
        for (int i = 0; i < length; i++) {
            List<Integer> list2 = list;
            nextPermutation(list2);
            System.out.println(list2);
            lists.add(new LinkedList<>(list2));
        }
        /*for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                //交换，保存
                List<Integer> list2=list;
                nextPermutation(list2);
                System.out.println(list2);
                lists.add(new LinkedList<>(list2));
                //swap(list,j+1,i);
            }
        }*/

        return lists;
    }

    public void nextPermutation(List<Integer> nums) {
        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i + 1) <= nums.get(i)) {
            i--;
        }
        if (i >= 0) {
            int j = nums.size() - 1;
            while (j >= 0 && nums.get(j) <= nums.get(i)) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(List<Integer> nums, int start) {
        int i = start, j = nums.size() - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);

    }

    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int num=len/2;
        for(int i=0;i<num;i++){
            rotateEdge(matrix,i,len);
            len-=2;
        }

    }

    public void rotateEdge(int[][] matrix, int num, int len) {
        //num为层数，len为旋转层的长度
        int a = len - 2;
        int[] save1 = new int[a + 1];
        int[] save2 = new int[a + 1];
        int[] save3 = new int[a + 1];
        //保存值
        for (int i = 0; i <= a; i++) {
            save1[i] = matrix[i+num][a + 1+num];
            save2[i] = matrix[a + 1+num][a + 1+num - i];
            save3[i] = matrix[num+a + 1 - i][num];
        }
        //操作
        for (int i = 0; i <= a; i++) {
            matrix[num+i][num+a + 1] = matrix[num+0][num+i];
            matrix[num+a + 1][num+a + 1 - i] = save1[i];
            matrix[num+a + 1 - i][num+0] = save2[i];
            matrix[num+0][num+i] = save3[i];
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists=new LinkedList<>();
        Map<String,List<String>> map=new HashMap<>();//存储相同条件字符串与list键值对
        //假如strs长度为0or1
        if(strs.length==0)return lists;
        List<String> list0=new LinkedList<>();
        list0.add(strs[0]);
        lists.add(list0);
        map.put(strs[0],list0);
        if(strs.length==1)return lists;
        //从第二个开始
        for(int i=1;i<strs.length;i++){
            boolean sign=false;
            for(Map.Entry<String,List<String>>entry:map.entrySet()){
                String str=entry.getKey();
                if(judeg(str,strs[i])){//符合同一组条件
                    entry.getValue().add(strs[i]);
                    sign=true;
                    break;
                }
            }
            if(!sign){//如果map中不存在与该字符串相关的，新建一个list，并保存在map中
                List<String> list=new LinkedList<>();
                list.add(strs[i]);
                map.put(strs[i],list);
                lists.add(list);
            }
        }

        return lists;
    }

    public boolean judeg(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        if(a.length()==1){
            if(a.charAt(0)!=b.charAt(0)){
                return false;
            }else return true;
        }
        //长度为2以上
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<a.length();i++){
            Character ch=a.charAt(i);
            if(map.containsKey(ch)){
                map.replace(ch,map.get(ch)+1);//如果存在，则次数加一
            }else {
                map.put(ch,1);
            }
        }
        //判断
        for(int i=0;i<a.length();i++){
            Character ch=b.charAt(i);
            if(map.containsKey(ch)&&map.get(ch)>0){
                map.replace(ch,map.get(ch)-1);//如果a中包含b总对应字符，则次数减1
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
    public boolean judeg1(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }

        //长度为2以上
        char[] ch1=a.toCharArray();
        Arrays.sort(ch1);
        String aout=String.valueOf(ch1);
        char[] ch2=b.toCharArray();
        Arrays.sort(ch2);
        String bout=String.valueOf(ch2);
        return aout.equals(bout);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new LinkedList<>();
        if(matrix.length==0)return list;
        int row=matrix.length;
        int colunm=matrix[0].length;
        int num=0;
        while (row>0&&colunm>0){
            spiralOrder(list,row,colunm,matrix,num);
            num++;
            row-=2;
            colunm-=2;
        }
        return list;
    }
    public void spiralOrder(List<Integer> list,int row,int column,int[][] matrix,int num){
        //第一阶段
        if(row>0) {
            for (int i = 0; i < column; i++) {
                list.add(matrix[num][num+i]);
            }
        }
        //第二阶段
        if(row>2){
            for(int i=0;i<row-2;i++){
                list.add(matrix[num+1+i][num+column-1]);
            }
        }
        //第三阶段
        if(row>=2){
            for(int i=column;i>0;i--){
                list.add(matrix[num+row-1][num+i-1]);
            }
        }
        //第四阶段
        if(row>2&&column>=2){
            for(int i=0;i<row-2;i++){
                list.add(matrix[num+row-2-i][num]);
            }
        }
    }

    public int[][] generateMatrix(int n) {
        if(n<=0) {
            return new int[0][0];}
        if(n==1){
            int[][] out={{1}};
            return out;
        }
        int[][]out=new int[n][n];
        //利用栈保存n个数据
        int number=1;
        int row=n;
        int num=0;
        while(row>0){
            generateMatrix(out,row,num,number);
            number+=4*(row-1);
            row-=2;
            num++;
        }
        return out;
    }
    public void generateMatrix(int[][]matrix,int row,int num,int number){
        //分阶段输出
        if(row>0) {
            for (int i = 0; i < row; i++) {
                //System.out.println(a);
                matrix[num][num+i]=number++;
            }
        }
        //第二阶段
        if(row>2){
            for(int i=0;i<row-2;i++){
                matrix[num+1+i][num+row-1]=number++;
            }
        }
        //第三阶段
        if(row>=2){
            for(int i=row;i>0;i--){
                matrix[num+row-1][num+i-1]=number++;
            }
        }
        //第四阶段
        if(row>2){
            for(int i=0;i<row-2;i++){
                matrix[num+row-2-i][num]=number++;
            }
        }
    }
    public double myPow(double x, int n) {
        if(n<Integer.MIN_VALUE||n>Integer.MAX_VALUE){
            return 0;
        }
        double out=1;
        boolean sign=true;
        if(n<0) sign=false;
        if(x==0) {
           if(!sign) {
               return 0;
           }else return 0;
        }
        n=Math.abs(n);
        for(int i=0;i<n;i++){
            out*=x;
            if(out<Double.MIN_VALUE||out>Double.MAX_VALUE){
                break;
            }
        }
        if(!sign) out=1/out;
        return out;
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode phead=new ListNode(-1);
        phead.next=head;
        //空链表或单节点
        if(head==null||head.next==null)return head;
        //对k取值确定一下
        if(k<=0) return phead.next;
        ListNode p=head;
        int num=1;
        Map<Integer,ListNode>map=new HashMap<>();
        while(p!=null){
            map.put(num++,p);
            p=p.next;
        }
        num-=1;
        k=k%num;
        if(k==0)return head;
        //将后k个前移
        map.get(num-k).next=null;
        phead.next=map.get(num-k+1);
        map.get(num).next=head;
        return phead;
    }
    public int[] plusOne(int[] digits) {
        int i;
        for( i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]=(digits[i]+1);
                break;
            }else {
                digits[i]=0;
                continue;
            }

        }
        if(i==-1){
            int[]out=new int[digits.length+1];
            out[0]=1;
            return out;
        }
        return digits;
    }
    public String addBinary(String a, String b) {
        int len1=a.length()-1;
        int len2=b.length()-1;
        StringBuffer out=new StringBuffer();
        int num=0;
        int sign=0;//保存进位
        while(len1>=0&&len2>=0){
            int c=(a.charAt(len1)+b.charAt(len2)+sign);
            if(c==2) {
                sign=1;
                c=0;
            }else c=1;
            out.insert(0,c);
        }
        if(len1<0){
            int c=(b.charAt(len2)+sign);
            if(c==2) {
                sign=1;
                c=0;
            }else c=1;
            out.insert(0,c);
        }
        return  out.toString();
    }
    public int mySqrt(int x) {

        return (int) Math.sqrt(x);
    }
    public int climbStairs(int n) {
        //斐波那契数列
        //递归比较耗时
        //可以用数组
        if(n==1)return 1;
        if(n==2)return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    //删除排序链表中重复元素，删去所有重复值
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode phead=new ListNode(-1);
        phead.next=head;
        //双指针
        ListNode p1=phead;
        ListNode p2=head;
        int num=1;
        while(p2!=null){

            if(p2.next!=null&&p2.next.val==p2.val){
                num++;
                p2=p2.next;
            }else {
                if(num>=2){
                    p2=p2.next;
                    p1.next=p2;
                    num=1;//跳过重复的
                }
                else if(num==1){
                    p1=p2;
                    p2=p2.next;
                }
            }
        }
        return phead.next;
    }
    //利用双指针？保存两个两个结点
    /*public ListNode partition(ListNode head, int x) {

    }*/
    public void setZeroes(int[][] matrix) {
        //两个list保存零值对应的行列值
        /*List<Integer> rows =new LinkedList<>();
        List<Integer> columns =new LinkedList<>();*/
        Map<Integer,Integer> map=new HashMap<>();
        //循环
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    map.put(i,j);
                }
            }
        }
        //遍历完成
        if(map.isEmpty()){
            return;
        }
        //有零元素
        for(int i=0;i<row;i++){
            if(map.containsKey(i)){
                //该行置零
                for(int j=0;j<column;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<column;i++){
            if(map.containsValue(i)){
                //该行置零
                for(int j=0;j<row;j++){
                    matrix[j][i]=0;
                }
            }
        }

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0)return false;
        if(row==1)return trueOrNot(matrix,0,target);
        int column=matrix[0].length;
        if(column==0)return false;
        if(target<matrix[0][0]) return false;
        if(target>matrix[row-1][column-1])return false;
        int i;
        for( i=0;i<matrix.length;i++){
            if(matrix[i][0]>target){//返回第i-1行
                return trueOrNot(matrix,i-1,target);
            }
        }
        return trueOrNot(matrix,i-1,target);
    }
    public boolean trueOrNot(int[][] matrix,int row,int target){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]==target){
                return true;
            }
        }
        return false;

    }
    public void sortColors(int[] nums) {
        int num0=0;
        int num1=0;
        int num2=0;
        if(nums.length==0) return;
        //第一遍遍历
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                num0++;
            }else if(nums[i]==1){
                num1++;
            }else if(nums[i]==2){
                num2++;
            }
        }
        //第二遍重写
        int i=0;
        while(num0!=0||num1!=0||num2!=0){
            if(num0!=0){
                nums[i++]=0;
                num0--;
            }else if(num1!=0){
                nums[i++]=1;
                num1--;
            }else if(num2!=0){
                nums[i++]=2;
                num2--;
            }
        }
    }
    public void sortColors1(int[] nums){
        int left=0;
        int right=nums.length-1;
        if(right==-1)return;
        int i=0;
        while(i<=right){
            if(nums[i]==0){//交换left与第i个元素
                int temp=nums[i];
                nums[i++]=nums[left];
                nums[left++]=temp;
            }
            else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right--]=temp;
            }
            else i++;
        }
    }
    public int removeDuplicates(int[] nums) {
        int pos=1;
        int num=1;
        if(nums.length<=2)return nums.length;
        int save=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==save){//等于保存的数
                if(num<2) {//少于两个保存
                    num++;
                    nums[pos++]=nums[i];
                    continue;
                }else {//num为2
                    nums[i]=0;
                    continue;
                }
            }else {//与save对应值不同
                save=nums[i];
                num=1;
                nums[pos++]=nums[i];
            }
        }
        return pos;
    }

        //先确定最小值的索引
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int mid = left + (right-left)/2;

            while(left <= right){
                if(nums[mid] == target){
                    return mid;
                }

                if(nums[left] <= nums[mid]){  //左边升序
                    if(target >= nums[left] && target <= nums[mid]){//在左边范围内
                        right = mid-1;
                    }else{//只能从右边找
                        left = mid+1;
                    }

                }else{ //右边升序
                    if(target >= nums[mid] && target <= nums[right]){//在右边范围内
                        left = mid +1;
                    }else{//只能从左边找
                        right = mid-1;
                    }

                }
                mid = left + (right-left)/2;
            }

            return -1;  //没找到
        }
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;

        ListNode phead1=new ListNode(-1);//保存小于x值的结点
        ListNode p0=phead1;
        ListNode phead2=new ListNode(-1);//保存大于x值的结点
        phead2.next=head;
        ListNode p=phead2;
        while(p.next!=null){
            if(p.next.val<x){//加到
                ListNode node=new ListNode(p.next.val);
                p0.next=node;
                p0=p0.next;
                p.next=p.next.next;//删去该结点
            }else {
                p=p.next;
            }
        }
        p0.next= phead2.next;
        return phead1.next;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list=new LinkedList<>();
        list.add(0);
        if(n==0) {
            return list;
        }
        int index=0;
        int num=1;
        while(index<n){

            int len=list.size();
            for(int i=len-1;i>=0;i--){
                int a=list.get(i)+num;
                list.add(a);
            }
            index++;
            num*=2;
        }
        return list;
    }
    public int numDecodings(String s) {
        char[] chars=s.toCharArray();
        int length=s.length();
        int num=0;
        for(int i=0;i<length-1;i++){
            int a=(chars[i]-'0')*10+(chars[i]-'0');
            if(chars[i]!='0'&&a<=26){
                num++;
            }else if(chars[i]!=0){
                num++;
            }else continue;
        }
        if(chars[length-1]!='0')num++;

        return num;
    }

    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
    List<List<Integer>> level=new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return level;
        Queue<TreeNode>queue=new LinkedList<>() ;
        queue.add(root);
        TreeNode temp;
        int num=1;
        while(!queue.isEmpty()){
            int cnt=queue.size();
            List<Integer> list0=new LinkedList<>();
            while(cnt-->0){
                temp=queue.poll();
                if(temp==null)continue;
                if(num%2==1) {//顺序
                    list0.add(temp.val);
                }else {
                    list0.add(0,temp.val);
                }
                queue.add(temp.left);
                queue.add(temp.right);
            }
            num++;
            if(list0.size()!=0)level.add(0,list0);
        }
        return level;
    }
    public int maxDepth(TreeNode root) {
        int num=0;
        if(root==null)return num;
        else num++;

        return num;
    }
    /**
     *
     * @param arr  代表全排列数字组成的数组
     * @param k 代表第几位
     */
    public void permutation(int[] arr, int k) {
        // 当 k 指向最后一个元素时,递归终止，打印此时的排列排列
        if (k == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
            //添加到List内
            /*List<Integer>list=IntStream.of(arr).boxed().collect(Collectors.toList());
            lists.add(list);*/
            //添加元素
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            lists.add(list);
        } else {
            List<Integer> list0=new LinkedList<>();
            for (int i = k; i < arr.length; i++) {
                // 将 k 与之后的元素 i 依次交换,然后可以认为选中了第 k 位
                if(list0.contains(arr[i])){
                    continue;
                }
                list0.add(arr[i]);
                swap(arr, k, i);

                // 第 k 位选择完成后，求剩余元素的全排列

                    permutation(arr, k + 1);

                // 这一步很关键：将 k 与 i 换回来，保证是初始的顺序
                swap(arr, k, i);
            }
        }
    }
    public static void swap (int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    List<List<Integer>> lists=new LinkedList<>();
    public List<List<Integer>> permute1(int[] nums) {
        permutation(nums,0);
        return lists;

    }
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);//该位置加上对应值为可到达最远位置
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1=(p1==null)?headB:p1.next;
            p2=(p2==null)?headA:p2.next;
        }
        return p1;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode phead=new ListNode(-1);
        ListNode p2;//用于保存原链表下一个结点
        ListNode p1=head;//
        while(p1!=null){
            p2=p1.next;
            ListNode node=phead.next;
            phead.next=p1;
            p1.next=node;
            p1=p2;
        }
        return phead.next;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode next=head.next;//原头结点的下一个结点，反转后原结点的上一个结点
        ListNode newhead=reverseList(next);
        //翻转后将原头结点加上
        next.next=head;
        head.next=null;
        return newhead;
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head==null||head.next==null&&n>=1||n<1)return null;
        ListNode p1=head;
        ListNode p2=head;
        ListNode phead=new ListNode(-1);
        phead.next=head;
        ListNode p3=phead;

        int num=0;
        while(p2!=null){
            p2=p2.next;
            num++;
            if(num>n){
                p1=p1.next;
                p3=p3.next;
            }

        }
        if(n<=num){//删去p1结点
            p3.next=p1.next;
            return phead.next;
        }else return null;
    }
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        ListNode pHead=new ListNode(-1);
        ListNode p0=pHead;
        ListNode p1=l1;
        ListNode p2=l2;
        int num=0;//进位
        int sum=0;
        int num1=0;
        int num2=0;
        while(p1!=null||p2!=null||num==1){
            if(p1!=null){
                num1=p1.val;
                p1=p1.next;
            }else{
                num1=0;
            }
            if(p2!=null){
                num2=p2.val;
                p2=p2.next;
            }else{
                num2=0;
            }
            sum=num1+num2+num;
            if(sum>=10) {
                num=1;
            }
            else{ num=0;}
            ListNode listNode=new ListNode(sum%10);
            pHead.next=listNode;
            pHead=pHead.next;

        }

        return p0.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l1.val==0)return l2;
        if(l2==null||l2.val==0)return l1;
        //保存到栈中
        Stack<Integer> stack1=optionStack(l1);
        Stack<Integer> stack2=optionStack(l2);
        int num=0;
        ListNode temp=new ListNode(0);
        temp.next=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||num!=0){
            int x=stack1.isEmpty()?0:stack1.pop();
            int y=stack2.isEmpty()?0:stack2.pop();
            ListNode node=new ListNode((x+y+num)%10);
            node.next=temp.next;
            temp.next=node;
            num=(x+y+num)/10;
        }
        //加法计算

        return temp.next;

    }
    public Stack<Integer> optionStack(ListNode head){
        Stack<Integer> stack=new Stack<>();
        ListNode p=head;
        while(p!=null){
            stack.push(p.val);
            p=p.next;
        }
        return stack;
    }
    public boolean   stackOption(Stack<ListNode>stack1,Stack<ListNode>stack2,ListNode temp,int num) {
        while (!stack2.isEmpty()) {//较短值
            temp = stack1.pop();//修改节点值
            int a = temp.val + stack2.pop().val;
            temp.val = (a + num)%10;
            num = a / 10;

        }
        return num==1;
    }
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new LinkedList<>();
        ListNode p=head;
        int i=0;
        while(p!=null){
            list.add(p);
            p=p.next;
        }
        //存完之后比较
        int len=list.size();
        for(i=0;i<len/2;i++){
            if(list.get(i).val==list.get(len-1-i).val){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] out=new ListNode[k];
        int len= lengthOfListNode(root);//返回长度；
        int result=len/k;
        int num=len%k;//前num个长度加一
        for(int i=0;i<k;i++){
            if(i<num){//result+1个
                ListNode temp=root;
                int sign=0;
                while(sign++<result+1){
                    root=root.next;
                }
                ListNode p=root;
                root=root.next;
                p.next=null;
                out[i]=temp;
            }else {//result个
                ListNode temp=root;
                int sign=0;
                while(sign++<result){
                    root=root.next;
                }
                ListNode p=root;
                root=root.next;
                p.next=null;
                out[i]=temp;
            }
        }
        return out;

    }
    public int lengthOfListNode(ListNode root){
        ListNode p=root;
        int out=0;
        while(p!=null){
            out++;
            p=p.next;
        }
        return out;
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return head;
        ListNode even=head.next;//保存偶数结点
        ListNode odd=even.next;//保存奇数结点
        ListNode save=head;//保存对应的奇数结点
        ListNode p=head;
        while(odd!=null&&even!=null){
            even.next=even.next.next;
            even=even.next;//下一个偶节点
            odd.next=save.next;
            save.next=odd;
            if(even!=null)odd=even.next;
            save=save.next;
        }

        return head;
    }

    private Stack<Integer>stack1=new Stack<>();
    private Stack<Integer>stack2=new Stack<>();
    public void MyQueue(){
    }
    public void push(int x) {//添加到尾部
        stack1.push(x);
    }
    public int pop() {
        in2out();
        return stack2.pop();
    }
    private void in2out(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return stack2.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int[] out=new int[len];
        for(int i=0;i<len;i++){
            int j;
            for(j=(i+1);j<len;j++){
                if(nums[j]>nums[i]){
                    out[i]=nums[j];
                    break;
                }
            }
            if(j==len){
                for( j=0;j<i;j++){
                    if(nums[j]>nums[i]){
                        out[i]=nums[j];
                        break;
                    }
                }
                if(j==i){
                    out[i]=-1;
                }
            }
        }
        return out;
    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }else {
                map.put(nums[i],1);

            }
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        Map<Integer,Integer>map=new HashMap<>();
        for(int m:nums){
            map.put(m,1);
        }
        //从最小值开始
        int longest=1;
        int num=1;
        for(int a:map.keySet()){
            if(map.containsKey(a+1)){
                num++;
                longest=Math.max(longest,num);
            }else {num=1;}
        }
        return longest;
}
    LinkedList<Integer>coinlist=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int len=coins.length;
        coinlist=saveCoins(amount,coins);

        if(coinlist.size()==0)return -1;
        return minOfLists(coinlist);
    }

    private int minOfLists(LinkedList<Integer> coinlist) {
        int min=Integer.MAX_VALUE;
        for(Integer a:coinlist){
           // System.out.println(a);
            min=a<min?a:min;
        }
        return min;
    }

    public LinkedList<Integer> saveCoins(int amout,int[] coins){
        if(amout==0){
            coinlist.add(temp.size());
            return coinlist;
        }
        for(int i=coins.length-1;i>=0;i--){
            int a=amout-coins[i];
            if(a>=0){
                temp.add(coins[i]);
                saveCoins(a,coins);
                temp.removeLast();
            }else {
                continue;
            }
        }
        return coinlist;
    }
    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return maxd;
    }
    public int depth(TreeNode root){
        if (root==null)return 0;
        int Left = depth(root.left);
        int Right = depth(root.right);
        maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int len=A.length;
        if(len<3)return false;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=A[i];
        }
        if(sum%3!=0)return false;
        int left=0;
        int leftSum=A[left];
        int right=len-1;
        int rightSum=A[right];
        while (left+1<right){
            if(leftSum==sum/3&&rightSum==sum/3){
                return true;
            }
            if(leftSum!=sum/3){
                leftSum+=A[++left];
            }
            if (rightSum!=sum/3){
                rightSum+=A[--right];
            }
        }
        return false;
    }

        public String gcdOfStrings(String str1, String str2) {
            // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            // 辗转相除法求gcd。
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }

        private int gcd(int a, int b) {
            return b == 0? a: gcd(b, a % b);
        }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        return nums[0]==nums[len/2]?nums[0]:nums[len];
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arrayLists=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> temp=new ArrayList();
            temp.add(nums[i]);
            int num=nums[i];//上升序列对应值
            for(int j=i;j<nums.length;j++){
                if (nums[j]>num){
                    num=nums[j];
                    temp.add(num);
                }
            }
            arrayLists.add(temp.size());
        }
        int num=Integer.MIN_VALUE;
        for(int a:arrayLists){
            if(a>num){
                num=a;
            }
        }
        return num;
    }
    public int findMinTimes(int[] postion,int[] supply,int distance,int bottle){
        int pos=0;//保存这次补给位置
        int num=0;//补给次数
        while (distance>0){
            //从补给的下一个开始，可到达的范围内补充最多的
            //若实现不了回溯
            for(int i=pos+1;i<postion.length;i++){

            }

        }
        return 0;
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m=grid.length;//行数
        int n=grid[0].length;//列数
        if(grid[0][0]==1||grid[m-1][n-1]==1)return -1;
        int dir[][]={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        Queue<Pair<Integer,Integer>>queue=new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            pathLength++;
            while(size-->0){
                Pair<Integer,Integer> pair=queue.poll();
                int x=pair.getKey();int y=pair.getValue();
                if(grid[x][y]==1) continue;//阻塞状态
                if(x==m-1&&y==n-1)return pathLength;

                grid[x][y]=1;//标记，过了该节点后标记，下次不需要再次遍历

                for(int data[]:dir){//遍历方向
                    int x1=x+data[0];
                    int y1=y+data[1];
                    if(x1<0||x1>=m||y1<0||y1>=n){//越界
                        continue;
                    }
                    queue.add(new Pair<>(x1,y1));
                }
            }

        }
        return -1;
    }
    public int numSquares(int n) {
        if(n<1)return -1;
        if(n==1)return 1;
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;//初始为最大值
            for(int j=1;j*j<=i;j++){
                dp[i]= Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
       List<Integer> squeras= generateSquera(n);
       boolean[] booleans=new boolean[n+1];
       booleans[n]=true;
       Queue<Integer>queue=new LinkedList<>();
       queue.add(n);
       int length=0;
       while (!queue.isEmpty()){
           int size=queue.size();
           length++;
           while (size-->0){
               int num=queue.poll();
               for(int a:squeras){
                   int next=num-a;
                   if(next<0) break;
                   if(next==0)return length;
                   if(booleans[next]){
                       continue;
                   }
                   booleans[next]=true;
                   queue.add(next);
               }

           }
       }
       return -1;
    }
    public ArrayList<Integer> generateSquera(int n){
        ArrayList<Integer> list=new ArrayList<>();
        int start=1;
        int differ=3;
        for(int i=0;start<=n;i++){
            list.add(start);
            start=start+differ;
            differ+=2;
        }
        return list;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        //Map<String,Boolean> map=new LinkedHashMap<>();
        boolean[] booleans=new boolean[wordList.size()];
        Queue<String>queue=new LinkedList<>();
        queue.add(beginWord);
        int idx=wordList.indexOf(beginWord);
        if(idx!=-1) {
            booleans[idx]=true;
        }
        int length=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            length++;
            while (size-->0){
                String temp=queue.poll();
                for(int i=0;i<wordList.size();i++){
                    String str=wordList.get(i);
                    if(booleans[i]) continue;//已经遍历过
                    if(differNum(temp,str)){
                        if(str.equals(endWord))return length+1;
                        booleans[i]=true;
                        queue.add(str);
                    }
                }
            }
        }
        return 0;
    }
    public boolean differNum(String beginWord,String endWord){
        int len=beginWord.length();
        int num=0;
        for(int i=0;i<len;i++){
            if(beginWord.charAt(i)==endWord.charAt(i)){
                continue;
            }else num++;
        }
        return num==1?true:false;
    }
    public int findCircleNum(int[][] M) {
        if (M == null||M.length==0) return 0;
        int m = M.length;
        int n = M[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    landSize(i,j,M);
                    num++;

                }
            }
        }
        return num;
    }
    public void landSize(int i,int j,int[][]grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return ;
        }
        int size=1;
        grid[i][j]=0;//沉岛
        landSize(i+1,j,grid);
        landSize(i,j+1,grid);
        landSize(i-1,j,grid);
        landSize(i,j-1,grid);
    }
    private String[] keys={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations=new LinkedList<>();
        if(digits.length()==0||digits==null)
            return combinations;
        doCombination(combinations,new StringBuilder(),digits);
        return combinations;
    }
    public void doCombination(List<String> combinations,StringBuilder prefix,final String digits){
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }//长度满足则存储
        int curDigits=digits.charAt(prefix.length())-'0';//对应的Keys索引
        String letters=keys[curDigits];
        for(char c:letters.toCharArray()){
            prefix.append(c);
            doCombination(combinations,prefix,digits);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    /*public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<>();
        if(n<0)return ans;
        if(n==1){
            ans.add("()");
            return ans;
        }

    }*/
    private int num=0;
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        if(len==1)return nums[0];
        quickSort(nums,0,len-1,len-k);
        return nums[len-k];
    }
    public void quickSort(int[] s,int l,int r,int k){
        if(l<r){
            int i=l,j=r,x=s[l];
            while (i<j){
                while (i<j&&s[j]>=x)
                    j--;
                if(i<j)s[i++]=s[j];

                while (i<j&&s[i]<=x)
                    i++;
                if(i<j)s[j--]=s[i];
            }
            s[i]=x;
            if(i==k) {return;}
            quickSort(s,l,i-1,k);
            quickSort(s,i+1,r,k);
        }
    }
    //非递归前序遍历
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current=stack.pop();
            res.add(current.val);

            if(current.right!=null){
                stack.push(current.right);
            }
            if (current.left!=null){
                stack.push(current.left);
            }
        }
        return res;

    }
    //非递归中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode p=root;

        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                res.add(p.val);
                p=p.right;
            }
        }

        return res;
    }
    //非递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode p=root;

        //标记最近出栈节点，判断是否p节点右孩子
        TreeNode pre=p;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                if(p.right==null||p.right==pre){
                    res.add(p.val);
                    pre=p;
                    p=null;
                }else {
                    stack.push(p);
                    p=p.right;
                    stack.push(p);
                    p=p.left;
                }
            }
        }
        return res;
    }
    public String largestNumber(int[] nums) {
        String []strings =new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i]=""+nums[i];
        }
        sortOperation(strings);
        if(strings[0].equals("0"))return "0";
        String out="";
        for(int i=0;i<strings.length;i++){
            out+=strings[i];
        }
        return out;

    }

    private void sortOperation(String[] strings) {
        for(int i=0;i<strings.length-1;i++){
            for(int j=strings.length-1;j>0;j--){
                if(compare(strings[j],strings[j-1])){//比较，大的置前
                    //交换
                    String temp=strings[j-1];
                    strings[j-1]=strings[j];
                    strings[j]=temp;
                }
            }
        }
    }

    private boolean compare(String a, String b) {
        /*String s1=a+b;
        String s2=b+a;
        int i=0;
        for(;i<s1.length();i++){
            if(s1.charAt(i)>s2.charAt(i)){
                return true;
            }else if(s1.charAt(i)<s2.charAt(i)){
                return false;
            }else {
                continue;
            }
        }
        return false;*/
        return (a+b).compareTo(b+a)>0;
    }
    public String printShortestPali(String s){
        if(isPali(s))return s;
        String out=new StringBuilder(s).reverse().toString();
        String subString=getSubString(s,out);
        if(subString==null)return out+s;

        int i=s.length()-subString.length();
        out+=subString;
        for(;i<s.length();i++){
            out+=s.charAt(i);
        }

    return out;
    }



    public static String getSubString(String s1,String s2){
        //记录相同字符串
        String sameString = null;
        //比较两个字符串的长度，这里是设置s1的长度大于s2
        if(s1.length()<s2.length()){
            //如果s2的长度大，那么就将两个字符串进行替换
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        //如果s2就被包含在s1中，那么这两个字符串最大的字串就是s2
        boolean isContains = s1.contains(s2);
        if(isContains){
            return s2;
        }else{
            boolean b1 = false;
            //如果s2不是两个字符串最大的子类，那么在进行循环查找
            for(int i=0;i<s2.length();i++){
                for(int j=0;j<=i;j++){
                    //获取每次进行比较的子字符串
                    String str = s2.substring(j,s2.length()-i+j);
                    System.out.println("第"+i+"次比较："+str);
                    if(s1.contains(str)){
                        sameString =str;
                        b1 = true;
                        break;
                    }
                }
                //如果比较到s2中最小的为2的时候还没有想同的字符串，我们就默认没有相同的子字符串
                if(s2.substring(0, s2.length()-i).length() ==2){
                    System.out.println("没有相同的子字符串");
                    b1 = true;
                    break;
                }
                if(b1 ==true){
                    break;
                }
            }

        }

        return sameString;

    }
    public boolean isPali(String s){
        if(s==null)return false;
        if(s.length()==1) return true;
        int i=0,j=s.length()-1;
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public boolean canOperation(int[]nums){
        if(nums.length==1)return true;
        int num=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                num++;
            }

        }
        return num<2;

    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int [] nums={4,2,3,1};
            System.out.println(s.canOperation(nums));
    }
}

