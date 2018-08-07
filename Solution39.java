// Leetcode 39: Combination Sum
import java.util.*;

public class Solution39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        Solution39 sol = new Solution39();
        List<List<Integer>> res = sol.combinationSum(candidates, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        List<Integer> cur = new ArrayList();
        backtracking(result, cur, candidates, 0, target);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> cur, int[] candidates, int idx, int remain) {
        if (remain == 0) {
            result.add(new ArrayList(cur));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            backtracking(result, cur, candidates, i, remain - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}