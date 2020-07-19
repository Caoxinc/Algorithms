package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue=new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);//先添加元素
        //将之前的移出来再添加
        int cnt=queue.size();
        while ((cnt-->1)){
            queue.add((queue.poll()));
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
