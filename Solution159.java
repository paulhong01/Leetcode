// Leetcode 159: Longest Substring with At Most Two Distinct Characters
import java.util.*;

public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int front = 0, end = 0;
        Map<Character, Integer> map = new HashMap();
        int result = 0;
        
        while (end < s.length()) {
            map.put(s.charAt(end), end);
            if (map.size() <= 2) {
                System.out.printf("%d %d\n", front, end);
                result = Math.max(result, end - front + 1);
                end++;
            } else {
                int newfront = map.get(s.charAt(front));
                
                for (int i = front; i <= newfront; i++) {
                    if (map.containsKey(s.charAt(i)) && map.getOrDefault(s.charAt(i), newfront) <= newfront) {
                        char c = s.charAt(i);
                        map.remove(c);
                    }
                }
                
            
                if(map.size() < 2) {
                    map.put(s.charAt(newfront), newfront);
                    front = newfront;
                } else {
                    front = newfront + 1;
                }
            }
        }
        return result;
    
    }
}