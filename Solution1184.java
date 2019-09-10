// Leetcode 1184: Distance Between Bus Stops
import java.util.*;

class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // TC:O(N), SC:O(1)
        int moveforward = 0;
        int cur = start;
        while (cur != destination) {
            moveforward += distance[cur++];
            if (cur == distance.length) {
                cur = 0;
            }
        }
        
        int movebackward = 0;
        cur = start;
        while (cur != destination) {
            cur--;
            if (cur == -1) {
                cur = distance.length-1;
            }
            movebackward += distance[cur]; 
        }
        return Math.min(moveforward, movebackward);
    }
}