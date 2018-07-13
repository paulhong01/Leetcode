// Leetcode 294: Flip Game II
// Description:
// You are playing the following Flip Game with your friend: 
// Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
// The game ends when a person can no longer make a move and therefore the other person will be the winner.
// Write a function to determine if the starting player can guarantee a win. 

// Example:
// Input: s = "++++"
// Output: true 
// Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
import java.util.*;

public class Solution294{
    public static void main(String[] args){
        String s = "++++";
        Solution294 sol = new Solution294();
        if (sol.canWin(s)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean canWin(String s) {
        // Backtracking: TC:O(n!!), SC:O(n!!)
        /* if (s == null || s.length() < 2)
            return false;
        
        for (int i = 1; i < s.length(); i++){
            String t = "";
            if (s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                t = s.substring(0, i-1) + "--" + s.substring(i+1);
                if (!canWin(t)){
                    return true;
                }
            }
        }
        return false; */
        
        // Backtracking with memorization, TC:O(2^n), SC:O(2^n)
        Map<String, Boolean> memo = new HashMap();
        return dfs(s, memo);
    }

    private boolean dfs(String s, Map<String, Boolean> memo){
        if (memo.containsKey(s)){
            return memo.get(s);
        }

        for (int i = 1; i < s.length(); i++){
            String t = "";
            if (s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                t = s.substring(0, i-1) + "--" + s.substring(i+1);
                if (!dfs(t, memo)){
                    memo.put(t, false);
                    return true;
                }
                memo.put(t, true);
            }
        }
        return false;
    }
}