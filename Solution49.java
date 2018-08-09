//Leetcode 49: Group Anagrams
import java.util.*;

public class Solution49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution49 sol = new Solution49();
        List<List<String>> res = sol.groupAnagrams(strs);
        for(List<String> temp: res) {
            for(String r: temp) {
                System.out.printf("%s ", r);
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Method 1: HashMap using sort, TC:O(nklog(k)), SC:O(nk), 
        // where n is the length of strs, and k is the maximum length of a string in strs.
        /* if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap();
        for (String s: strs) {
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String key = String.valueOf(cur);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values()); */


        // Method 2: HashMap using count array, TC:O(nk), SC:O(nk)
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap();
        int[] count = new int[26];
        for (String s: strs) {
            Arrays.fill(count, 0);
            for (char c: s.toCharArray()) count[c - 'a']++;

            StringBuilder keytemp = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keytemp.append("#");
                keytemp.append(count[i]);
            }
            String key = keytemp.toString();

            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
}