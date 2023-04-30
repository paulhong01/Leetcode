// Leetcode 2609: Find the Longest Balanced Substring of a Binary String

class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        // TC:O(N), SC:O(1)
        int count0 = 0, count1 = 0, ret = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count0 = (count1 > 0)?1:count0+1;
                count1 = 0;
            } else {
                count1++;
            }
            ret = Math.max(ret, 2*Math.min(count0, count1));
        }
        return ret;
    }
}
