// Leetcode 791: Custom Sort String
import java.util.*;

public class Solution791{
    public static void main(String[] args){
        String S = "cba", T = "abcd";
        Solution791 sol = new Solution791();
        String result = sol.customSortString(S, T);
        System.out.println(result);
    }

    public String customSortString(String S, String T) {
        // TC:O(N_S+N_T), SC:O(N_T), where N_S = S.length(), N_T = T.length()
        // Record T character
        int[] record = new int[26];
        for (int i = 0; i < T.length(); i++){
            record[T.charAt(i) - 'a']++;
        }

        // Mapping S
        String result = "";
        for (int i = 0; i < S.length(); i++){
            while (record[S.charAt(i) - 'a'] > 0){
                result += S.charAt(i);
                record[S.charAt(i) - 'a']--;
            }
        }

        // Fill the remaining character
        for (int i = 0; i < 26; i++){
            while (record[i] > 0){
                result += (char)(i + 'a');
                record[i]--;
            }
        }

        return result; 
    }
}