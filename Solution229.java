// Leetcode 229: Majority Element II
import java.util.*;

public class Solution229 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};

        Solution229 sol = new Solution229();
        List<Integer> res = sol.majorityElement(nums);
        System.out.println(res);
    }

    public List<Integer> majorityElement(int[] nums) {
        // TC:O(n), SC:O(1)
        int n1 = -1, n2 = -1, count1 = 0, count2 = 0;
        for (int n: nums) {
            if (n1 == n) count1++;
            else if (n2 == n) count2++;
            else if (count1 == 0) {
                n1 = n;
                count1++;
            } else if (count2 == 0) {
                n2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Collect the result
        count1 = 0;
        count2 = 0;
        for (int n: nums) {
            if (n1 == n)    count1++;
            else if (n2 == n)   count2++;
        }

        List<Integer> result = new ArrayList();
        if (count1 > nums.length/3) result.add(n1);
        if (count2 > nums.length/3) result.add(n2);
        return result;
    }
}