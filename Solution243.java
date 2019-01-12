// Leetcode 243: Shortest Word Distance
import java.util.*;

class Solution243 {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        Solution243 sol = new Solution243();
        System.out.println(sol.shortestDistance(words, word1, word2));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        // Method 1: Brute force
        // TC:O(n^2), SC:O(n)
        // Map<String, List<Integer>> map = new HashMap();
        // for (int i = 0; i < words.length; i++) {
        //     List<Integer> list = map.get(words[i]);
        //     if (list == null) {
        //         map.put(words[i], new ArrayList());
        //     }
        //    map.get(words[i]).add(i);
        // }
        
        // List<Integer> list1 = map.get(word1);
        // List<Integer> list2 = map.get(word2);
        // int result = Integer.MAX_VALUE;
        // for (int l1: list1) {
        //     for (int l2: list2) {
        //         result = Math.min(result, Math.abs(l2-l1));
        //     }
        // }
        // return result;
        
        // Method 2: One pass
        // TC:O(n), SC:O(1)
        int i1 = -1, i2 = -1;
        int result = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            
            if (i1 != -1 && i2 != -1) {
                result = Math.min(result, Math.abs(i1-i2));
            }
        }
        return result;
    }
} 