// Leetcode1598: Crawler Log Folder 

class Solution1598 {
    public int minOperations(String[] logs) {
        // TC:O(N), SC:O(1)
        int level = 0;
        for (String log : logs) {
            if (log.length() == 2) {
                if (log.charAt(0) == '.') {
                    continue;
                }
            } else if (log.length() == 3) {
                if (log.charAt(0) == '.' && log.charAt(1) == '.') {
                    level = Math.max(level-1, 0);
                    continue;
                } 
            }
            level++;
        }
        return level;
    }
}
