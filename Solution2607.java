// Leetcode 2607: Make K-Subarray Sums Equal

class Solution2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        // TC:O(k * NlogN), SC:O(N)
        long ret = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> cycle = new ArrayList<Integer>();
            for (int j = i; arr[j] != 0; j = (j + k)%arr.length) {
                cycle.add(arr[j]);
                arr[j] = 0;
            }

            Collections.sort(cycle);
            for (int n : cycle) {
                ret += Math.abs(n - cycle.get(cycle.size()/2));
            }
        }
        return ret;
    }
}
