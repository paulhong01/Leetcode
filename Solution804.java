//Leetcode 804: Unique Morse Code Words
import java.util.*;

public class Solution804{
    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution804 sol = new Solution804();
        int result = sol.uniqueMorseRepresentations(words);
        System.out.println(Integer.toString(result));
    }

    public int uniqueMorseRepresentations(String[] words) {
        // TC:O(S), SC:O(S), where S = the sum of the lengths of words in words
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet();
        for (String w: words){
            String temp = "";
            for (int i = 0; i < w.length(); i++){
                temp += code[w.charAt(i) - 'a'];
            }
            set.add(temp);
        }
        return set.size();
    }
}