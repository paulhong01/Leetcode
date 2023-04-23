// Leetcode 2605: Form Smallest Number From Two Digit Arrays

class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        // TC:O(N+M), SC:O(N), where N = nums1.length and M = nums2.length
        Set<Integer> one_element = new HashSet<Integer>();
        int one_smallest_element = 9;
        for (int num : nums1) {
            one_element.add(num);
            one_smallest_element = Math.min(one_smallest_element, num);
        }

        int common = -1;
        int two_smallest_element = 9;
        for (int num : nums2) {
            if (one_element.contains(num)) {
                common = (common == -1)?num:Math.min(common, num);
            }
            two_smallest_element = Math.min(two_smallest_element, num);
        }

        return common != -1?common:Math.min(one_smallest_element, two_smallest_element)*10+Math.max(one_smallest_element, two_smallest_element);
    } 
}
