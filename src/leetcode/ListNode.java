package leetcode;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     void print(){
         ListNode p=this;
         while(p!=null){
             System.out.print(p.val+"->");
             p=p.next;
         }
     }
  }