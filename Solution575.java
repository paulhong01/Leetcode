//Leetcode 575: Distribute Candies
import java.util.*;

public class Solution575{
    public static void main(String[] args){
        int[] candies = {1,1,2,2,3,3};
        Solution575 sol = new Solution575();
        int result = sol.distributeCandies(candies);
        System.out.println(result);
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet();
        for (int c: candies){
            s.add(c);
            if (s.size() == candies.length/2)   return s.size();
        }
        return Math.min(s.size(), candies.length/2);
    }
}