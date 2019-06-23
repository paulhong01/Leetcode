// Leetcode 253: Meeting Rooms II
import java.util.*;

class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        // TC:O(Nlog(N)), SC:O(N)
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return (a[0]==b[0])?(b[1]-a[1]):(a[0]-b[0]);
           } 
        });
        
        int result = (intervals.length > 0)?1:0;
        int cur_req = 1;
        PriorityQueue<Integer> end_times = new PriorityQueue();
        if (intervals.length > 0)   end_times.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            while (!end_times.isEmpty() && end_times.peek() <= intervals[i][0]) {
                end_times.poll();
            }
            end_times.add(intervals[i][1]);
            result = Math.max(result, end_times.size());
        }
        return result;
    }
}