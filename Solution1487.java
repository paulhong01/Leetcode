// Leetcode 1487: Making File Names Unique
import java.util.*;

class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ret = new String[names.length];
        
        int idx = 0;
        for (String name : names) {
            if (map.containsKey(name)) {
                int val = map.get(name);
                StringBuilder temp = new StringBuilder(name);
                temp.append("(");
                temp.append(String.valueOf(val));
                temp.append(")");
                while (map.containsKey(temp.toString())) {
                    val++;
                    temp = new StringBuilder(name);
                    temp.append("(");
                    temp.append(String.valueOf(val));
                    temp.append(")");
                }
                ret[idx++] = temp.toString();
                map.put(temp.toString(), 1);
                map.put(name, val+1);
            } else {
                ret[idx++] = name;
                map.put(name, 1);
            }
        }
        return ret;
    }
}