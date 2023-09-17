// Leetcode 2829: Determine the Minimum Sum of a k-avoiding Array

class Solution2829 {
    public int minimumSum(int n, int k) {
        // TC:O(N), SC:O(N)
        int num_sum = 0;
        Set<Integer> avoided_num = new HashSet<Integer>();
        int idx = 1, count = 0;
        while (count < n) {
            if (avoided_num.contains(idx)) {
                idx++;
                continue;
            }
            num_sum += idx;
            avoided_num.add(k-idx);
            idx++;
            count++;
        }
        return num_sum;
    }
}