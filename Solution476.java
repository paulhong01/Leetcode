// Leetcode 476: Number Complement
import java.util.*;

class Solution476 {
    public static void main(String[] args) {
        Solution476 sol = new Solution476();
        System.out.println(sol.findComplement(5));
    }

    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num^mask;
    }
}