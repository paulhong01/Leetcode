//Leetcode 520: Detect Capital
import java.util.*;

public class Solution520{
    public static void main(String[] args){
        String word = "USA";
        Solution520 sol = new Solution520();
        if (sol.detectCapitalUse(word)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean detectCapitalUse(String word) {
        // TC:O(n), SC:O(1), where n = word.length()
        int count = 0;
        for(char c: word.toCharArray()){
            if (Character.isUpperCase(c)){
                count++;
            }
        }
        return ((count == word.length()) || (count == 1 && Character.isUpperCase(word.charAt(0))) || (count == 0) );
    }
}