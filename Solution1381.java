// Leetcode 1381: Design a Stack With Increment Operation
import java.util.*;

class CustomStack {
    // Double linked list. TC:O(N), SC:O(N)
    int MAX_SIZE = 0;
    LinkedList<Integer> list = new LinkedList<>();
    public CustomStack(int maxSize) {
        MAX_SIZE = maxSize;
    }
    
    public void push(int x) {
        if (list.size() < MAX_SIZE) {
            list.addLast(x);
        }
    }
    
    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.pollLast();
    }
    
    public void increment(int k, int val) {
        int range = Math.min(k, list.size());
        for (int i = 0; i < range; i++) {
            int original_val = list.get(i);
            list.set(i, original_val+val);
        }
    }
}