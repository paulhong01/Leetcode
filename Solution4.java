// Leetcode 4: Median of Two Sorted Arrays
import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        Solution4 sol = new Solution4();
        double res = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TC:O(log(min(m, n))), SC:O(1)
        int m, n;
        if (nums1.length < nums2.length) {
            m = nums1.length;
            n = nums2.length;
        } else {
            m = nums2.length;
            n = nums1.length;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = (imin + imax)/2;
            int j = (m + n + 1)/2 - i;
            if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else {
                int maxleft = 0;
                if (i == 0) maxleft = nums2[j - 1];
                else if (j == 0) maxleft = nums1[i - 1];
                else maxleft = Integer.max(nums1[i - 1], nums2[j - 1]);
                if ((n + m) % 2 == 1)   return maxleft;

                int maxright = 0;
                if (i == m) maxright = nums2[j];
                else if (j == n) maxright = nums1[i];
                else maxright = Integer.min(nums1[i], nums2[j]);

                return (maxleft + maxright) / 2.0;
            }
        }
        return 0.0;
    }
}