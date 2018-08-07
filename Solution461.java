// Leetcode 461: Hamming Distance

public class Solution461 {
    public static void main(String[] args) {
        int x = 1, y = 4;

        Solution461 sol = new Solution461();
        int res = sol.hammingDistance(x, y);
        System.out.println(res);
    }

    public int hammingDistance(int x, int y) {
        // Method 1: Bit manipulation, TC:O(n), SC:O(1), where n = number of bits of x xor y
        // int check = x^y;
        // int count = 0;
        // while (check != 0) {
        //     int temp = check&1;
        //     if (temp == 1) {
        //         count++;
        //     }
        //     check >>= 1;
        // }
        // return count;

        // Method 2: Java bit count, TC:O(1), SC:O(1)
        // Java bitcount function is O(1) time complexity
        return Integer.bitCount(x^y);
    }
}