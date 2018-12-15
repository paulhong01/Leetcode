// Leetcode 589: N-ary Tree Preorder Traversal

class Solution589 {
    public List<Integer> preorder(Node root) {
        // Method 1: Recursively
        // if (root == null)   return new ArrayList();
        // List<Integer> result = new ArrayList();
        // dfs(root, result);
        
        // Method 2: Iteratively
        if (root == null)   return new ArrayList();
        
        List<Integer> result = new ArrayList();
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);
            List<Node> cur_child = cur.children;
            for (int i = cur_child.size() - 1; i >= 0; i--) {
                stack.push(cur_child.get(i));
            }
        }
        return result;
    }
    
    private void dfs(Node cur, List<Integer> result) {
        if (cur == null)    return;
        
        result.add(cur.val);
        List<Node> cur_child = cur.children;
        for (int i = 0; i < cur_child.size(); i++) {
            dfs(cur_child.get(i), result);
        }
    }
} 