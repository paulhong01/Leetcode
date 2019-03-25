// Leetcode 1021: Best Sightseeing Pair
import java.util.*;

class Solution1021 {
    public int maxScoreSightseeingPair(int[] A) {
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int tempresult = Integer.MIN_VALUE;
            System.out.println(i);
            for (int j = i; j < A.length; j++) {
                tempresult = Math.max(A[j] + A[j-i] - i, tempresult);
            }
            if (tempresult < result) {
                break;
            } else {
                result = tempresult;
            }
        }
        return result;
    }
}