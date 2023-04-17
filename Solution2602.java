// Leetcode 2602: Minimum Operations to Make All Array Elements Equal

class Solution2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // TC:O((N+M)*log(N)), SC:O(N)
        Arrays.sort(nums);
        int N = nums.length;
        long[] prefix = new long[N+1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        List<Long> operations = new ArrayList<Long>();
        for (int q : queries) {
            int i = Arrays.binarySearch(nums, q);
            if (i < 0) i = -(i + 1);
            operations.add(1L * q * (2 * i - N) + prefix[N] - 2 * prefix[i]);
        }
        return operations;
    }
}
