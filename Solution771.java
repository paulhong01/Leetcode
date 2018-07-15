//Leetcode 771: Jewels and Stones
import java.util.*;

public class Solution771{
    public static void main(String[] args){
        String J = "aA";
        String S = "aAAbbbb";
        Solution771 sol = new Solution771();
        int res = sol.numJewelsInStones(J, S);
        System.out.println(res);
    }

    public int numJewelsInStones(String J, String S) {
        // Method 1: Hashset, TC:O(n_j+n_s), SC:O(n_j), where n_j = J.lenght(), n_s = S.length()    
        // Set<Character> set = new HashSet();
        // int J_length = J.length(), S_length = S.length();
        // for (int i = 0; i < J_length; i++){
        //     set.add(J.charAt(i));
        // }

        // int result = 0;
        // for (int i = 0; i < S_length; i++){
        //     if (set.contains(S.charAt(i))){
        //         result++;
        //     }
        // }
        // return result;

        // Method 2: Use Java Function
        int result = 0;
        int S_length = S.length();
        for (int i = 0; i < S_length; i++){
            char c = S.charAt(i);
            if (J.indexOf(c) != -1){
                result++;
            }
        }
        return result;
    }
}