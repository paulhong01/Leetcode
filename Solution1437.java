// Leetcode 1437: Check If All 1's Are at Least Length K Places Away
import java.util.*;

class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        // TC:O(N), SC:O(1)
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (i - prev - 1 < k) {
                        return false;
                    }
                    prev = i;
                }
            }
        }
        return true;
    }
}