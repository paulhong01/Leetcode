class Solution946 {    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int popidx = 0, pushidx = 0;
       
        while (popidx < popped.length || pushidx < pushed.length) {
            if (stack.size() == 0 || popped[popidx] != stack.peek()) {
                if (pushidx == pushed.length) {
                    return false;
                } 
                stack.push(pushed[pushidx++]);
            } else {
                stack.pop();
                popidx++;
            }   
        }
        
        return true;
    }
}