// Leetcode 77: Combinations
import java.util.*;

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtracking(ret, cur, visited, 1, n, k);
        return ret;
    }
    
    private void backtracking(List<List<Integer>> ret, List<Integer> cur, int start_idx, int end_idx, int req_len) {
        if (cur.size() == req_len) {
            ret.add(new ArrayList(cur));
            return;
        }
        
        for (int i = start_idx; i <= end_idx; ++i) {          
            cur.add(i);
            backtracking(ret, cur, visited, i+1, end_idx, req_len);
            cur.remove(cur.size()-1);
        }
    }
}