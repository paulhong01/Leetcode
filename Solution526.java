// Leetcode 526: Beautiful Arrangement
import java.util.*;

public class Solution526{
    public static void main(String[] args){
        int N = 2;
        Solution526 sol = new Solution526();
        int result = sol.countArrangement(N);
        System.out.println(Integer.toString(result));
    }

    int count = 0;

    public int countArrangement(int N) {
        // TC:O(k), SC:O(N), where k = the number of valid permutations
        boolean[] visited = new boolean[N+1];
        helper(visited, 1, N);
        return count;
    }

    private void helper(boolean[] visited, int pos, int N){
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++){
            if (!visited[i] && (pos % i ==0 || i % pos == 0)){
                visited[i] = true;
                helper(visited, pos+1, N);
                visited[i] = false;
            }
        }
    }
}