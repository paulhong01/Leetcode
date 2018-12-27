// Leetcode 292: Nim Game
import java.util.*;

class Solution292 {
    public static void main(String[] args) {
        int n = 4;
        Solution292 sol = new Solution292();
        if (sol.canWinNim(n)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}