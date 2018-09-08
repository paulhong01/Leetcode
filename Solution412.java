// Leetcode 412: Fizz Buzz
import java.util.*;

public class Solution412 {
    public static void main(String[] args) {
        int n = 15;

        Solution412 sol = new Solution412();
        List<String> res = sol.fizzBuzz(n);
        for (String r: res) {
            System.out.println(r);
        }
    }

    public List<String> fizzBuzz(int n) {
        // TC:O(n), SC:O(1)
        List<String> result = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }   
        return result;
    }
}