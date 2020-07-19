package NewCODE;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/4/11 17:48
 */
public class ListNode {
     int val;
     ListNode next=null;

    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next){//构造方法，创建节点同时指向下一个节点
        this.val=val;
        this.next=next;}

    public void print(){
        System.out.print(this.val);
        while (this.next!=null){
            System.out.print("-->");
            this.next.print();
        }
    }
    //添加新结点
    public void add(int newval){
        ListNode newNode=new ListNode(newval);
        if(this.next==null){
            this.next=newNode;
        }else{
            this.next.add(newval);
        }
    }

}
