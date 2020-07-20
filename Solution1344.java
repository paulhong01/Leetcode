// Leetcode 1344: Angle Between Hands of a Clock
import java.util.*;

class Solution1344 {
    public double angleClock(int hour, int minutes) {
        // TC:O(N), SC:O(N)
        double hour_angle = (double)hour/12*360 + (double)minutes/60*30;
        double minute_angle = (double)minutes/60*360;
        
        double angle_diff = Math.abs(hour_angle - minute_angle);
        return angle_diff < (360 - angle_diff)?angle_diff:(360-angle_diff);
    }
}