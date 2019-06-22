// Leetcode 225: Implement Stack using Queues
import java.util.*;

class MyStack225 {

    List<Integer> list;
    /** Initialize your data structure here. */
    public MyStack() {
        list = new ArrayList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return list.get(list.size()-1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size()==0;
    }
}