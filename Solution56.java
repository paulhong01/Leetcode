// Leetcode 56: Merge Intervals
import java.util.*;

class Interval {
    int start;
    int end;
    Interval()  {start = 0; end = 0;}
    Interval(int s, int e)  {start = s; end = e;}
}

public class Solution56 {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList();
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(1, 5));

        Solution56 sol = new Solution56();
        List<Interval> res = sol.merge(intervals);
        for (Interval temp: res) {
            System.out.printf("%d , %d\n", temp.start, temp.end);
        }
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return (a.start < b.start)?-1:a.start==b.start?0:1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> result = new LinkedList();
        for (Interval interval: intervals) {
            if (result.size() == 0 || result.getLast().end < interval.start) {
                result.add(interval);
            } else {
                result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
        }
        return result;
    }
}