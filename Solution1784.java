// Leetcode 1784: Check if Binary String Has at Most One Segment of Ones
import java.util.*;

class Solution1784 {
    public boolean checkOnesSegment(String s) {
        // TC:O(N), SC:O(1)
        return !s.contains("01");
    }
}