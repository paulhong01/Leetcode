// Leetcode 245: Shortest Word Distance III
import java.util.*;

class Solution245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // TC:O(N), SC:O(N)
        Map<String, List<Integer>> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList());
            }
            map.get(words[i]).add(i);
        }
        
        int result = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        if (word1.equals(word2)) {
            for (int i = 1; i < list1.size(); i++) {
                result = Math.min(result, list1.get(i)-list1.get(i-1));
            }
            return result;
        }
        int idx1 = 0, idx2 = 0;
        while (true) {
            result = Math.min(result, Math.abs(list1.get(idx1)-list2.get(idx2)));
            if (idx1 == list1.size()-1 && idx2 == list2.size()-1) {
                break;
            } else if (idx1 == list1.size()-1) {
                idx2++;
            } else if (idx2 == list2.size()-1) {
                idx1++;
            } else if (list1.get(idx1) < list2.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return result;
    }
}