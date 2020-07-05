// Leetcode 1497: Check If Array Pairs Are Divisible by k
import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Greedy:  TC:(N), SC:O(N)
        int[] frequency = new int[k];
        for(int num : arr){
            num %= k;
            if(num < 0) num += k;
            frequency[num]++;
        }
        if(frequency[0]%2 != 0) return false;
        
        for(int i = 1; i <= k/2; i++)
            if(frequency[i] != frequency[k-i]) return false;
			
        return true;
    }
}