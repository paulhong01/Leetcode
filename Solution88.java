// Leetcode 88: Merge Sorted Array
import java.util.*;

public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        Solution88 sol = new Solution88();
        sol.merge(nums1, m, nums2, n);
        for (int n1: nums1) {
            System.out.printf("%d ", n1);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // TC:O(n), SC:O(1)
        int k = m + n - 1;
        m--;
        n--;
        while (m >=0 && n >= 0) nums1[k--] = nums1[m] > nums2[n]?nums1[m--]:nums2[n--];
        while (n >= 0)  nums1[k--] = nums2[n--];
        return;
    }
}