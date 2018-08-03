//Leetcode 3: Longest Substring Without Repeating Characters
import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        String s = " ";

        Solution3 sol = new Solution3();
        int res = sol.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        // Method 1: Brute force, TC:O(n^2), SC:O(n^2)
        // int maxlength = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     int count = 0;
        //     Set<Character> set = new HashSet();

        //     for (int j = i; j < s.length(); j++) {
        //         if(set.contains(s.charAt(j))) {
        //             count = 1;
        //         } else {
        //             count++;
        //             if (count > maxlength) {
        //                 maxlength = count;
        //             }
        //             set.add(s.charAt(j));
        //         }
        //     }
        // }
        // return maxlength;

        // Method 2: HashMap
        Map<Character, Integer> map = new HashMap();

        int size = s.length();
        int result = 0, i = 0, j = 0;
        while (j < size) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            result = Math.max(result, j - i );
            map.put(s.charAt(j), j);
            j++;
        }
        return result;
    }
}