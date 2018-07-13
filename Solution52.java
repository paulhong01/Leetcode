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
    private List<Integer> col = new ArrayList();

    public int totalNQueens(int n) {
        // Method 1: Easy understand but complexity too high, TC:O(n!*n)
        /* boolean[] visited = new boolean[n+1];
        helper(visited, new ArrayList<Integer>(), 0, n); */

        // Method 2: Use three boolean array, column, diagonal \, diagonal /,  to check the validation
        // TC:O(n!), SC:O(n)
        boolean[] visited_col = new boolean[n+1];   // col check
        boolean[] visited_diagl = new boolean[2*n]; // diagonal:direction -> /
        boolean[] visited_diagr = new boolean[2*n]; // diagonal: direction -> \
        helper2(visited_col, visited_diagl, visited_diagr, 1, n);
        return count;
    }

    private void helper2(boolean[] visited_col, boolean[] visited_diagl, boolean[] visited_diagr, int pos, int length){
        if (pos == length+1){
            col.clear();
            count++;
            return;
        }

        for (int col = 1; col < visited_col.length; col++){
            if (!visited_col[col] && !visited_diagl[pos+col-1] && !visited_diagr[length-pos+col]){
                visited_col[col] = true;
                visited_diagl[pos+col-1] = true;
                visited_diagr[length-pos+col] = true;
                helper2(visited_col, visited_diagl, visited_diagr, pos+1, length);
                visited_col[col] = false;
                visited_diagl[pos+col-1] = false;
                visited_diagr[length-pos+col] = false;
            }
        }
    }

    private void helper(boolean[] visited, List<Integer> cur, int pos, int length){
        if (pos == length){
            cur.clear();
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