class Solution {
    public List<Integer> postorder(Node root) {
        // Method 1: Recursive
        // TC:O(N), SC:O(N)
        // List<Integer> result = new ArrayList();
        // dfs(root, result);
        // return result;
        
        // Method 2: Iterative
        // TC:O(N), SC:O(N)
        if(root == null)    return new ArrayList();
        Stack<Node> stack = new Stack();
        stack.push(root);
        LinkedList<Integer> result = new LinkedList();
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            List<Node> cur_child = cur.children;
            result.addFirst(cur.val);
            for (Node c: cur_child) {
                stack.push(c);
            }
        }
        return result;
    }
    
    private void dfs(Node cur, List<Integer> result) {
        if (cur == null)    return;
        
        List<Node> cur_child = cur.children;
        for (int i = 0; i < cur_child.size(); i++) {
            dfs(cur_child.get(i), result);
        }
        result.add(cur.val);
    }
}