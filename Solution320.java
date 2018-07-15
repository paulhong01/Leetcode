// Leetcode 320: Generalized Abbreviation
// Description:
// Write a function to generate the generalized abbreviations of a word. 
// Note: The order of the output does not matter.

// Example:
// Input: "word"
// Output:
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
import java.util.*;

public class Solution320{
    public static void main(String[] args){
        String word = "word";
        Solution320 sol = new Solution320();
        List<String> result = sol.generateAbbreviations(word);
        System.out.println(result);
    }

    public List<String> generateAbbreviations(String word) {
        // Method 1: Easy understanding, check every position
        // List<String> result = new ArrayList();
        // result.add(word);
        // helper(result, word, 0);
        // return result;

        // Method 2: Backtracking, inspired by @soymubien, TC:O(2^n), SC:O(2^n)
        List<String> result = new ArrayList();
        helper2(result, word, 0, "", 0); 
        return result;
    }

    private void helper2(List<String> result, String word, int pos, String cur, int count){
        if (pos == word.length()){
            if (count > 0) cur += count;
            result.add(cur);
        } else{
            //Abbreviate
            helper2(result, word, pos+1, cur, count+1);
            // Do not abbreviate
            helper2(result, word, pos+1, cur + ((count>0)?count:"") + word.charAt(pos), 0);
            
        }
    }

    private void helper(List<String> result, String word, int start){
        for (int length = 1; length <= word.length(); length++){
            for (int idx = start; idx < word.length(); idx++){
                boolean flag = true;
                if (idx == 0){
                    for (int temp = 0; temp < length; temp++){
                        if (Character.isDigit(word.charAt(idx+temp))){
                            flag = false;
                        }
                    }
                } else if (idx + length - 1 >= word.length()){
                    flag = false;
                } else if (Character.isDigit(word.charAt(idx-1))){
                    flag = false;
                } else{
                    for (int temp = 0; temp < length; temp++){
                        if (Character.isDigit(word.charAt(idx+temp))){
                            flag = false;
                        }
                    }
                }

                if (flag){
                    String t = word.substring(0,idx) + Integer.toString(length) + word.substring(idx+length);
                    result.add(t);
                    helper(result, t, idx+1);
                }
            }
        }
    }
}

