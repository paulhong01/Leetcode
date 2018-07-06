// Leetcode 537: Complex Number Multiplication
import java.util.*;

public class Solution537{
    public static void main(String[] args){
        String a = "1+1i", b = "1+1i";
        Solution537 sol = new Solution537();
        String result = sol.complexNumberMultiply(a, b);
        System.out.println(result);
    }

    public String complexNumberMultiply(String a, String b) {
        // TC:O(1), SC:O(1)
        int idx_plus = a.indexOf("+");
        int[] num_a = {Integer.parseInt(a.substring(0, idx_plus)), Integer.parseInt(a.substring(idx_plus+1, a.length()-1))};
        idx_plus = b.indexOf("+");
        int[] num_b = {Integer.parseInt(b.substring(0, idx_plus)), Integer.parseInt(b.substring(idx_plus+1, b.length()-1))};

        String result = Integer.toString(num_a[0]*num_b[0] - num_a[1]*num_b[1]) + "+" + Integer.toString(num_a[0]*num_b[1] + num_a[1]*num_b[0]) + "i";
        return result;
    }
}