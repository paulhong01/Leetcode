//Leetcode 500: Keyboard Row
import java.util.*;

public class Solution500{
    public static void main(String[] args){
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        Solution500 sol = new Solution500();
        String[] res = sol.findWords(words);
        for (String r: res){
            System.out.printf("%s ", r);
        }
        System.out.println("");
    }

    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList();
        for (String s: words){
            int row_idx = 0;
            for (int i = 0; i < rows.length; i++){
                if (rows[i].indexOf(Character.toLowerCase(s.charAt(0))) != -1)   
                    row_idx = i;
            }
            
            for (int i = 0; i < s.length(); i++){
                if (rows[row_idx].indexOf(Character.toLowerCase(s.charAt(i))) == -1)
                    break;
                else if (i == s.length() -1)
                    result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }
}