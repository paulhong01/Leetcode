// Leetcode 784 : Letter Case Permutation
/* Discription:
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create. */
import java.util.*;

public class Solution784{
    public static void main(String[] args){
        String S = "a1b2";
        Solution784 sol = new Solution784();
        List<String> result = sol.letterCasePermutation(S);
        for (String r: result){
            System.out.printf("%s ", r);
        }
        System.out.println("");
    }

    public List<String> letterCasePermutation(String S) {
        // Method 1: BFS, TC:O(2^n*n), SC:O(2^n*n), where n = S.length()
        /* List<String> result = new ArrayList();
        result.add(S);
        for (int idx_string = 0; idx_string < S.length(); idx_string++){
            int size = result.size();
            for (int idx_list = 0; idx_list < size; idx_list++){
                if (Character.isDigit(result.get(idx_list).charAt(idx_string))){
                    break;
                }
                
                // letter toggle
                char[] cur = result.get(idx_list).toCharArray();
                cur[idx_string] = Character.isUpperCase(cur[idx_string])?Character.toLowerCase(cur[idx_string]):Character.toUpperCase(cur[idx_string]);
                result.add(new String(cur));
            }
        }
        return result;   */

        // Method 2: Backtracking, TC:O(2^n*n), SC:O(2^n*n)
        List<String> result = new ArrayList();
        backtracking(S.toCharArray(), result, 0);
        return result;
    }

    private void backtracking(char[] s, List<String> res, int idx){
        if (idx == s.length){
            res.add(new String(s));
            return;
        }
        backtracking(s, res, idx+1);
        if (Character.isLetter(s[idx])){
            s[idx]^=(1<<5);
            backtracking(s, res, idx+1);
        }

    }
}
