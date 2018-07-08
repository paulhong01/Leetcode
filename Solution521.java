//Leetcode 521: Longest Uncommon Subsequence I 
import java.util.*;

public class Solution521{
    public static void main(String[] args){
        String a = "abc", b = "cdc";
        Solution521 sol = new Solution521();
        int result = sol.findLUSlength(a, b);
        System.out.println(Integer.toString(result));
    }

    public int findLUSlength(String a, String b) {
        // TC:O(min(a.length(), b.length())), SC:O(1)
        return (a.equals(b))?-1:Math.max(a.length(), b.length());
    }
}