// Leetcode 252: Meeting Rooms
import java.util.*;

class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        // TC:O(Nlog(N)), SC:O(1)
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a,int[] b) {
               return (a[0]==b[0])?(b[1]-a[1]):(a[0]-b[0]);
           } 
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1])    return false;
        }
        return true;
    }
}