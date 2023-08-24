// Leetcode 232: Implement Queue using Stacks

class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        temp.push(x);
        stack = new Stack<Integer>();
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}
