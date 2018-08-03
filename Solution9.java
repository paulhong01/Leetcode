// Leetcode 9: Palindrome Number
import java.util.*;

public class Solution9 {
    public static void main(String[] args) {
        int x = -121;

        Solution9 sol = new Solution9();
        boolean res = sol.isPalindrome(x);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean isPalindrome(int x) {
        // TC:O(n), SC:O(1)
        String instr = Integer.toString(x);
        int start = 0, end = instr.length() - 1;
        while (start <= end) {
            if (instr.charAt(start++) != instr.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}