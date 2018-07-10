// Leetcode 52: N-Queens II
import java.util.*;

public class Solution52{
    public static void main(String[] args){
        int n = 4;
        Solution52 sol = new Solution52();
        int result = sol.totalNQueens(n);
        System.out.println(result);
    }
    private int count = 0;
    private List<List<Integer>> check = new ArrayList<List<Integer>>();

    public int totalNQueens(int n) {
        // Method 1: Easy understand but complexity too high, TC:O(n^2)
        boolean[] visited = new boolean[n+1];
        helper(visited, new ArrayList<Integer>(), 0, n);
        return count;
    }

    private void helper(boolean[] visited, List<Integer> cur, int pos, int length){
        if (pos == length){
            check.add(new ArrayList<Integer>(cur));
            count++;
            return;
        }

        for (int i = 1; i <= length; i++){
            if (pos == 0){
                visited[i] = true;
                cur.add(i);
                helper(visited, cur,pos+1, length);
                visited[i] = false;
                cur.remove(pos);
            } else if (!visited[i]){
                boolean flag = true;
                for (int j = 0; j < pos; j++){
                    if ((pos - j) == Math.abs(i - cur.get(j))){
                       flag = false;
                       break; 
                    }
                }
                if (flag){
                    visited[i] = true;
                    cur.add(i);
                    helper(visited, cur,pos+1, length);
                    visited[i] = false;
                    cur.remove(pos);
                }
            }
        }
    }
}