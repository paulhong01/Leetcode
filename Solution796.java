// Leetcode 796: Rotate String
import java.util.*;

public class Solution796 {
    public static void main(String[] args) {
        // String A = "abcde";
        // String B = "cdeab";
        String A = "a";
        String B = "a";
        // String B = "abced";


        Solution796 sol = new Solution796();
        boolean res = sol.rotateString(A, B);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean rotateString(String A, String B) {
        // Method 1: Use java substring to rotate String A
        // TC:O(n), SC:O(1)
        if (A.length() != B.length()) {
            return false;
        } else if (A.length() <= 1) {
            return (A.equals(B));
        }

        int len = A.length();
        for (int i = 1; i < len; i++) {
            String check = A.substring(i, len) + A.substring(0, i);
            if (check.equals(B)) {
                return true;
            }
        }
        return false;

        // Method 2: All rotations of A are contained in A+A. Thus, simply check whether B is a substring of A+A
        // TC:O(n^2), SC:O(n)
        // return (A.length() == B.length()) && ((A + A).contains(B));
    }   
}