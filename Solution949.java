// Leetcode 949: Largest Time for Given Digits
import java.util.*;

public class Solution949 {
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Solution949 sol = new Solution949();
        String res = sol.largestTimeFromDigits(A);
        System.out.println(res);
    }

    public String largestTimeFromDigits(int[] A) {
        // Method 1: Brute force
        // TC:O(1), SC:O(1)
        // input: [1,2,3,4]
        // 0:0, 1:1, 2:1, 3:1, 4:1, 5:0, 6:0, 7:0, 8:0, 9:0
            
        // time: 23:59 
        // 2: 0:0, 1:1, 2:0, 3:1, 4:1, 5:0, 6:0, 7:0, 8:0, 9:0
        // 3: 0:0, 1:1, 2:0, 3:0, 4:1, 5:0, 6:0, 7:0, 8:0, 9:0
        // 5: break
        // time: 23:58
        int[] frequency = new int[10];
        for (int n: A) {
            frequency[n]++;
        }
        
        for (int hour = 23; hour >= 0; hour--) {
            int[] tempfreq = frequency.clone();
            int hour1 = hour/10, hour2 = hour%10;
            if (tempfreq[hour1] == 0 || tempfreq[hour2] == 0)   continue;
            tempfreq[hour1]--;
            if (tempfreq[hour2] == 0)   continue;
            tempfreq[hour2]--;
            for (int min = 59; min >= 0; min--) {
                int min1 = min/10, min2 = min%10;
                if (tempfreq[min1] == 0) continue;
                tempfreq[min1]--;
                if (tempfreq[min2] == 0) {
                    tempfreq[min1]++;
                    continue;
                } else {
                    String res = String.format("%02d:%02d", hour, min);
                    return res;
                }
            }
        }
        return "";
    
}
}