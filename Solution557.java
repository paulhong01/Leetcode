// Leetcode 557: Reverse Words in a String III
import java.util.*;

public class Solution557{
    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        Solution557 sol = new Solution557();
        String result = sol.reverseWords(s);
        System.out.println(result);
    }

    public String reverseWords(String s) {
        // Method 1 : TC:O(n), SC:O(n), where n = S.length()
        /* String[] s_arr = s.split(" ");
        String result = "";
        for(int i = 0; i < s_arr.length; i++){
            result += reverse(s_arr[i]);
            if (i != s_arr.length-1){
                result += " ";
            }
        }
        return result; */

        // Method 2: Stringbuilder, TC:O(n), SC:O(n), where n = S.length()
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }else{
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

    private String reverse(String s_in){
        char[] ch = s_in.toCharArray();
        int l = 0, r = s_in.length()-1;
        while (l < r){
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
        return (new String(ch));
    }
}