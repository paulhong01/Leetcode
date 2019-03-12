// Leetcode 57: Insert Interval
import java.util.*;

class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //if curstart > newend
        //       => add newstart, newend
        //       => break loop
        //         => fill the remaining item
        //else if cursend > newInterval.start && 
        //    => newstart = min(curstart, newInterval.start), newend = max(curend, newInterval.end)
        // else:
        //      add to result list
        //      curidx++
        // TC:O(n), SC:O(n)
        int newstart = newInterval.start, newend = newInterval.end;
        int curidx = 0;
        List<Interval> result = new ArrayList<>();
        
        while (curidx < intervals.size()) {
            int curstart = intervals.get(curidx).start, curend = intervals.get(curidx).end;
            
            if (curstart > newend) {
                break;
            } else if (curend >= newstart) {
                newstart = Math.min(curstart, newstart);
                newend = Math.max(curend, newend);
                curidx++;
            } else {
                result.add(intervals.get(curidx++));
            }
        }
        
        result.add(new Interval(newstart, newend));
        while (curidx < intervals.size()) {
            result.add(intervals.get(curidx++));
        }
        return result;
    }
}