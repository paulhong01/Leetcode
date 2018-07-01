//Leetcode 495: Teemo Attacking
import java.util.*;

public class Solution495{
    public static void main(String[] args){
        //int[] timeSeries = {1, 4};
        int[] timeSeries = {1, 2, 3, 4, 5};
        int duration = 5;
        Solution495 s = new Solution495();
        int result = s.findPoisonedDuration(timeSeries, duration);
        System.out.println(Integer.toString(result));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // TC:O(N), SC:O(1), where N = timeSeries.length
        if (timeSeries.length == 0)
            return 0;
        else if (timeSeries.length == 1)
            return duration;

        int result = 0;
        for (int i = 1; i < timeSeries.length; i++){
            int gap = timeSeries[i] - timeSeries[i-1];
            result = gap >= duration?result+duration:result+gap;
        }
        return result+duration;
    } 
}