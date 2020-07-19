package newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/24 21:24
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        pre(root);
        mid(root);
        end(root);
        int len=list1.size();
        int[][]a=new int[3][len];
        for(int i=0;i<len;i++){
            a[0][i]=list1.get(i);
            a[1][i]=list2.get(i);
            a[2][i]=list3.get(i);
        }
        return a;
    }
    private  List<Integer> list1=new ArrayList<>();
    private  List<Integer> list2=new ArrayList<>();
    private  List<Integer> list3=new ArrayList<>();
    public void pre(TreeNode root){
        if(root==null){
            return ;
        }
        list1.add(root.val);
        pre(root.left);
        pre(root.right);
    }
    public void mid(TreeNode root){
        if(root==null){
            return ;
        }
        mid(root.left);
        list2.add(root.val);
        mid(root.right);
    }
    public void end(TreeNode root){
        if(root==null){
            return ;
        }
        end(root.left);
        end(root.right);
        list3.add(root.val);
    }
}
