// Leetcode 1904: The Number of Full Rounds You Have Played
import java.util.*;

class Solution1904 {
    public int numberOfRounds(String startTime, String finishTime) {
        // TC:O(1), SC:O(1)
        int start = 60*Integer.parseInt(startTime.substring(0, 2)) + Integer.parseInt(startTime.substring(3));
        int finish = 60*Integer.parseInt(finishTime.substring(0, 2)) + Integer.parseInt(finishTime.substring(3));
        if (finish < start) {
            finish += 60*24;
        }
        
        return Math.max(0, (int)(Math.floor(finish/15.0) - Math.ceil(start/15.0)));
    }
}