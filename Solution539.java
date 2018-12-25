// Leetcode 539: Minimum Time Difference
import java.util.*;

class Solution539 {

    public static void main(String[] args) {
        Solution539 sol = new Solution539();
        String[] time = {"23:59","00:00"};
        List<String> timePoints = Arrays.asList(time);
        int res = sol.findMinDifference(timePoints);
        System.out.println(res);
    }

    public int findMinDifference(List<String> timePoints) {
        // TC:O(n), SC:O(1)
        boolean[] record = new boolean[24*60];
        for (String time: timePoints) {
            int hour = Integer.valueOf(time.substring(0, 2));
            int min = Integer.valueOf(time.substring(3));
            if (record[hour*60 + min]) return 0;
            record[hour*60 + min] = true;
        }
        
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE, prev = -1;
        int result = Integer.MAX_VALUE;
        for (int t = 0; t < 24*60; t++) {
            if (record[t]) {
                if (prev == -1) {
                    prev = t;
                } else {
                    result = Math.min(result, t - prev);
                }
                first = Math.min(first, t);
                last = Math.max(last, t);
                prev = t;
            }
        }
        return Math.min(result, 24*60 + first - last);
    }
}