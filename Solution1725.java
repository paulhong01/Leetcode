// Leetcode 1725: Number Of Rectangles That Can Form The Largest Square
import java.util.*;

class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        // TC:O(N), SC:O(1)
        int max_len = 0;
        int ret_num = 0;
        for (int[] rectangle : rectangles) {
            int min_side = Math.min(rectangle[0], rectangle[1]);
            if (min_side > max_len) {
                ret_num = 1;
                max_len = min_side;
            } else if (max_len == min_side) {
                ret_num++;
            }
        }
        return ret_num;
    }
}