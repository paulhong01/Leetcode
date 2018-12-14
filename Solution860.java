// Leetcode 860: Lemonade Change
import java.util.*;


class Solution860 {
    public static void main(String[] args) {
        Solution860 sol = new Solution860();
        int[] bills = {5, 5, 5, 10, 20};
        boolean res = sol.lemonadeChange(bills);
        if (res)    System.out.println("True");
        else    System.out.println("False");
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b: bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            
            if (five < 0)   return false;
        }
        return true;
    }
}