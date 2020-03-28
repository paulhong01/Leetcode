// Leetcode 1389: Create Target Array in the Given Order
import java.util.*;

class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        // TC:O(N^2), SC:O(N)
        int len = nums.length;
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}