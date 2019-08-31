// Leetcode 825: Friends Of Appropriate Ages
import java.util.*;

class Solution825 {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;
        
        int ret = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            for (int ageB = 0; ageB <= 120; ageB++) {
                if (0.5*ageA+7 >= ageB) continue;
                if (ageB > ageA)    continue;
                if (ageB > 100 && ageA < 100)   continue;
                ret += count[ageA]*count[ageB];
                if (ageA == ageB)   ret -= count[ageA];
            }
        }
        return ret;
    }
}