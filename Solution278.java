// Leetcode 278:  First Bad Version
import java.util.*;

public class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (isBadVersion(m) && (m==n || isBadVersion(m+1)) && (m == 0 || !isBadVersion(m-1))) {
                return m;
            } else if (isBadVersion(m)) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}