// Leetcode 2600: K Items With the Maximum Sum

class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        // TC:O(1), SC:O(1)
        if (numOnes >= k) {
            return k;
        }
        if (numOnes + numZeros >= k) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }
}