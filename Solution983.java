// Leetcode 983: Minimum Cost For Tickets
import java.util.*;

class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        int lastdate = 0;
        Set<Integer> set = new HashSet();
        for (int d: days) {
            lastdate = Math.max(lastdate, d);
            set.add(d);
        }
        
        int[] date = new int[366];
        for (int i = 1; i <= lastdate; i++) {
            if (!set.contains(i)) {
                date[i] = date[i-1];
            } else {
                if (i >= 30) {
                    date[i] = Math.min(date[i-1] + costs[0], date[i-7] + costs[1]);
                    date[i] = Math.min(date[i], date[i-30] + costs[2]);
                } else if (i >= 7) {
                    date[i] = Math.min(date[i-1] + costs[0], date[i-7] + costs[1]);
                    date[i] = Math.min(date[i], date[0] + costs[2]);
                } else if (i >= 1) {
                    date[i] = Math.min(date[i-1] + costs[0], date[0] + costs[1]);
                    date[i] = Math.min(date[i], date[0] + costs[2]);
                }
            }
        }
        return date[lastdate];
        
    }
}