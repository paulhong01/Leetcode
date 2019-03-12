// Leetcode 77: Combinations
import java.util.*;

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curlist = new ArrayList();
        
        backtracking(result, curlist, n, k, 1);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, List<Integer> curlist, int n, int k, int idx) {
        if (curlist.size() == k) {
            result.add(new ArrayList(curlist));
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            curlist.add(i);
            backtracking(result, curlist, n, k, i+1);
            curlist.remove(curlist.size() - 1);
        }
    }
    
    
}