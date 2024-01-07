// Leetcode 2894: Divisible and Non-divisible Sums Difference

public class Solution2894 {
    public int differenceOfSums(int n, int m) {
        // TC:O(N), SC:O(1)
        int num1 = 0, num2 = 0;
        for (int i = 1; i <=n; ++i) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }
        return num1 - num2;
    }
}
