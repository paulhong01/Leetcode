// Leetcode 819: Most Common Word
import java.util.*;

public class Solution819 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        Solution819 sol = new Solution819();
        String res = sol.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // TC:O(b + p), SC:O(b + p), wher b = banned.length(), p = number of String in paragraph
        Set<String> set = new HashSet();
        for (String s: banned) {
            set.add(s);
        }

        String[] p = paragraph.split("[! ?',;.]+", -1);
        Map<String, Integer> map = new HashMap();
        String result = "";
        int tempmax = 0;
        for (String temp: p) {
            temp = temp.toLowerCase();
            int tempcount = map.getOrDefault(temp, 0) + 1;
            map.put(temp, tempcount);
            if (!set.contains(temp) && tempcount > tempmax) {
                result = temp;
                tempmax = tempcount;
            }
        }

        return result;
    }
}