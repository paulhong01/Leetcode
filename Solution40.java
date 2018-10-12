// Leetcode 40: Combination Sum II
import java.util.*;

public class Solution40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Solution40 sol = new Solution40();
        List<List<Integer>> result = sol.combinationSum2(candidates, target);
        for (List<Integer> l: result) {
            for (int r: l) {
                System.out.printf("%d ", r);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, 0, cur, result, target);
        return result;
    }

    private void dfs(int[] candidates, int start, List<Integer> cur, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            else {
                cur.add(candidates[i]);
                dfs(candidates, i + 1, cur, result, target - candidates[i]);
                cur.remove(cur.size()-1);
                while (i + 1 < candidates.length && candidates[i+1] == candidates[i])   i++;
            }
        }
    }
}