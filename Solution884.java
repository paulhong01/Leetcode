// Leetcode 884: Uncommon Words from Two Sentences
import java.util.*;

public class Solution884 {
    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        
        Solution884 sol = new Solution884();
        String[] res = sol.uncommonFromSentences(A, B);
        for (String r: res) {
            System.out.println(r);
        }
    }

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap();
        String[] A_arr = A.split("[ ]+", -1);
        String[] B_arr = B.split("[ ]+", -1);
        
        for (String temp: A_arr) {
            int freq = map.getOrDefault(temp, 0) + 1;
            map.put(temp, freq);
        }
        
        for (String temp: B_arr) {
            int freq = map.getOrDefault(temp, 0) + 1;
            map.put(temp, freq);
        }
        
        List<String> resultlist = new ArrayList();
        for (String key: map.keySet()) {
            int value = map.get(key);
            if (value == 1) resultlist.add(key);
        }

        return resultlist.toArray(new String[resultlist.size()]);
    }
}