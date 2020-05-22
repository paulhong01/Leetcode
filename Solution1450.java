// Leetcode 1450: Number of Students Doing Homework at a Given Time
import java.util.*;

class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // TC:O(N), SC:O(N)
        int ret = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ret++;
            }
        }
        return ret;
    }
}