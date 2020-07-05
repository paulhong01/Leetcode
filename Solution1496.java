// Leetcode 1496: Path Crossing
import java.util.*;

class Solution1496 {
    public boolean isPathCrossing(String path) {
        // Linear search and form a string key, TC:O(N), SC:O(N)
        Set<String> set = new HashSet<>();
        set.add("0:0");
        int row = 0, col = 0;
        for (char c: path.toCharArray()) {
            if (c == 'N') {
                row--;
            } else if (c == 'S') {
                row++;
            } else if (c == 'E') {
                col++;
            } else {
                col--;
            }
            
            String cur = String.valueOf(row) + ":" + String.valueOf(col);
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }
        return false;
    }
}