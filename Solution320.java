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
        List<String> result = new ArrayList();
        result.add(word);
        helper(result, word, 0);
        return result;
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
                    // System.out.printf("Word: %s, t: %s, length: %d, start: %d\n", word, t, length, start);
                    result.add(t);
                    helper(result, t, idx+1);
                }
            }
        }
    }
}

