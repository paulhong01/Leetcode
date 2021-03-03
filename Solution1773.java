// Leetcode 1773: Count Items Matching a Rule
import java.util.*;

class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // TC:O(N), SC:(1), where N = items.size()
        int find_idx = 0;
        if (ruleKey.equals("type")) {
            find_idx = 0;
        } else if (ruleKey.equals("color")) {
            find_idx = 1;
        } else if (ruleKey.equals("name")) {
            find_idx = 2;
        }
        
        int count = 0;
        for (List<String> item : items) {
            if (item.get(find_idx).equals(ruleValue)) {
                ++count;
            }
        }
        return count;
    }
}