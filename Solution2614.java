// Leetcode 2614: Prime In Diagonal

class Solution2614 {
    public int diagonalPrime(int[][] nums) {
        // TC:O(N^2), SC:O(1)
        int N = nums.length;
        int max_prime = 0;
        for (int i = 0; i < N; i++) {
            if (isPrimeNum(nums[i][i])) {
                max_prime = Math.max(max_prime, nums[i][i]);
            }
            if (isPrimeNum(nums[i][N-i-1])) {
                max_prime = Math.max(max_prime, nums[i][N-i-1]);
            }
        }
        return max_prime;
    }

    private boolean isPrimeNum(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
