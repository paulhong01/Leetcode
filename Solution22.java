//Leetcode 22: Generate Parentheses
import java.util.*;

public class Solution22{
    public static void main(String[] args){
        //int n = 3;
        int n = 1;
        Solution22 sol = new Solution22();
        List<String> result = sol.generateParenthesis(n);
        for (String r: result){
            System.out.println(r);
        }
    }

    public List<String> generateParenthesis(int n) {
        // TC:O(4^n/n^(1/2)), SC:TC:O(4^n/n^(1/2)), Reference:https://en.wikipedia.org/wiki/Catalan_number#Proof_of_the_formula
        List<String> result = new ArrayList();
        int[] par = new int[2]; // par[0]->"(", par[1]->")"
        Arrays.fill(par, n);
        StringBuilder cur = new StringBuilder("(");
        par[0]--;
        helper(result, cur, par, 1, 2*n);
        return result;
    }

    private void helper(List<String> result,  StringBuilder cur, int[] par, int pos, int length){
        if (pos == length){
            result.add(cur.toString());
            return;
        }

        for (int i = 0; i <= 1; i++){
            // check left par
            if (i == 0 && par[i] > 0){
                cur.append("(");
                par[i]--;
                helper(result, cur, par, pos+1, length);
                cur.deleteCharAt(pos);
                par[i]++;
            } else if (i == 1 && par[0] < par[1]){
                cur.append(")");
                par[i]--;
                helper(result, cur, par, pos+1, length);
                cur.deleteCharAt(pos);
                par[i]++;
            }
        }
    }
}