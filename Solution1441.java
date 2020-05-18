// Leetcode 1441: Build an Array With Stack Operations
import java.util.*;


class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();
        int idx = 0;
        for (int i = 1;i <= n; i++) {
            if (idx == target.length) {
                break;
            } else if (target[idx] > i) {
                ret.add("Push");
                ret.add("Pop");
            } else {
                idx++;
                ret.add("Push");
            }
        }
        return ret;
    }
}