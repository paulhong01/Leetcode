//Leetcode 824: Goat Latin
import java.util.*;

public class Solution824{
    public static void main(String[] args){
        String S = "I speak Goat Latin";
        Solution824 sol = new Solution824();
        String result = sol.toGoatLatin(S);
        System.out.println(result);
    }

    public String toGoatLatin(String S) {
        //TC:O(N^2), SC:O(N^2), where N = S.length()
        String[] arr = S.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            result.append(checkvowel(new StringBuilder(arr[i])));
            for (int j = 0; j < i+1; j++){
                result.append("a");
            }
            if (i != arr.length-1)
                result.append(" ");
        }
        return result.toString();
    }

    private String checkvowel(StringBuilder str){
        if(Character.toLowerCase(str.charAt(0)) != 'a' && Character.toLowerCase(str.charAt(0)) != 'e' &&  Character.toLowerCase(str.charAt(0)) != 'i'&& Character.toLowerCase(str.charAt(0)) != 'o'&& Character.toLowerCase(str.charAt(0)) != 'u'){
            char temp = str.charAt(0);
            str.deleteCharAt(0);
            str.append(temp);
        }
        str.append("ma");
        return str.toString();
    }
}