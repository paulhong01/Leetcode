// Leetcode 1023: Camelcase Matching
import java.util.*;

class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList();
        for (String s: queries) {
            int idx2 = 0;
            if (s.length() < pattern.length()) {
                result.add(false);
                continue;
            }
            
            boolean flag = true;
            for (int idx1 = 0; idx1 < s.length(); idx1++) {
                if (Character.isUpperCase(s.charAt(idx1))) {
                    if (idx2 >= pattern.length() || s.charAt(idx1) != pattern.charAt(idx2)) {
                        flag = false;
                        break;
                    } else {
                        idx2++;
                    }
                } else if (idx2 < pattern.length() && s.charAt(idx1) == pattern.charAt(idx2)) {
                    idx2++;
                }
            }
            
            if (flag && idx2 == pattern.length()) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}