// Leetcode 402: Remove K Digits
import java.util.*;

public class Solution402 {
    public static void main(String[] args) {
        String num = "10";
        int k = 2;

        Solution402 sol = new Solution402();
        String res = sol.removeKdigits(num, k);
        System.out.println(res);
    }

    public String removeKdigits(String num, int k) {
        // TC:O(n), SC:O(n)
        // Convert String to int list
        List<Integer> n = new ArrayList();
        for (int i = 0; i < num.length(); i++) {
            n.add(Integer.valueOf(num.substring(i, i + 1)));
        }
        
        // Remove the element that is in local max
        int idx = 0;
        while (idx < n.size() - 1 && k > 0) {
            if (n.get(idx) > n.get(idx + 1)) {
                n.remove(idx);
                idx = idx == 0?idx:idx -1;
                k--;
            } else {
                idx++;
            }
        }

        idx = n.size() - 1;
        for (idx = n.size() - 1; k > 0 && idx >=0; idx--) {
            n.remove(idx);
            k--;
        }

        // Remove 0
        idx = 0;
        while (idx < n.size()) {
            if (n.get(idx) == 0)    n.remove(idx);
            else break;
        }
        // System.out.println(n);

        StringBuilder result = new StringBuilder();
        if (n.size() == 0)  result.append("0");
        else {
           for (int i = 0; i < n.size(); i++) {
            result.append(Integer.toString(n.get(i)));
           } 
        }
        
        return result.toString();
    }
}