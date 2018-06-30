// Leetcode 844: Backspace String Compare
import java.util.*;

public class Solution844{
    public static void main(String args[]){
        //String S = "ab#c", T = "ad#c";
        //String S = "ab##", T = "c#d#";
        //String S = "a##c", T = "#a#c";
        //String S = "y#fo##f", T = "y#f#o##f";
        String S = "a##c", T = "#a#c";
        Solution844 s = new Solution844();
        boolean result = s.backspaceCompare(S, T);
        if (result)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public boolean backspaceCompare(String S, String T) {
        // TC: O(max(N1,N2)), SC:O(1), where N1 = S.length(), N2 = T.length()
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '#' && i == 0){
                S = S.substring(i+1);
                i = -1;
            }else if (S.charAt(i) == '#'){
                S = S.substring(0, i-1) + S.substring(i+1);
                i = (i-2);
            }
        }
        for (int i = 0; i < T.length(); i++){
            if (T.charAt(i) == '#' && i == 0){
                T = T.substring(i+1);
                i = -1;
            } else if (T.charAt(i) == '#'){
                T = T.substring(0, i-1) + T.substring(i+1);
                i = (i-2);
            }
        }
        return S.equals(T);
    }
}