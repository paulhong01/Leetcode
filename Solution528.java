// Leetcode 528: Random Pick with Weight
import java.util.*;

class Solution528 {
    Random random;
    int[] sum;
    public Solution(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
        }
        this.sum = w;
    }
    
    public int pickIndex() {
        int l = 0, r = this.sum.length-1;
        int idx = random.nextInt(sum[sum.length-1])+1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (sum[m] == idx) {
                return m;
            } else if (sum[m] < idx) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}