// Leetcode 893: Groups of Special-Equivalent Strings
import java.util.*;

class Solution893 {
    public int numSpecialEquivGroups(String[] A) {
        // Method 1: Sorting
        // TC:O(n^2log(n)), SC:O(n)
        // Set<String> code = new HashSet();
        // for (String s: A) {
        //     List<Character> odd = new ArrayList();
        //     List<Character> even = new ArrayList();
        //     for (int i = 0; i < s.length(); i++) {
        //         if (i % 2 == 0) even.add(s.charAt(i));
        //         else odd.add(s.charAt(i));
        //     }
        //     Collections.sort(odd);
        //     Collections.sort(even);
            
        //     StringBuilder tempcode = new StringBuilder();
        //     for (char c: odd)   tempcode.append(c);
        //     for (char c: even)  tempcode.append(c);
        //     code.add(tempcode.toString());
        // }
        // return code.size();
        
        // Method 2: Record array
        // TC:O(n), SC:O(n)
        Set<String> code = new HashSet();
        for (String s: A) {
            int[] record = new int[52];
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a' + 26*(i%2)]++;
            }
            code.add(Arrays.toString(record));
        }
        return code.size();
    }
} 