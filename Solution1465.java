// Leetcode 1465: Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
import java.util.*;

class Solution1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> hc = new LinkedList<>();
        List<Integer> vc = new LinkedList<>();
        for (int h_v: horizontalCuts) {
            hc.add(h_v);
        }
        hc.add(0);
        hc.add(h);
        
        for (int v: verticalCuts) {
            vc.add(v);
        }
        vc.add(0);
        vc.add(w);
        
        Collections.sort(hc);
        Collections.sort(vc);
        
        int max_hc = 0, max_vc = 0;
        for (int i = 1; i < hc.size(); i++) {
            max_hc = Math.max(max_hc, hc.get(i) - hc.get(i-1));
        }
        for (int i = 1; i < vc.size(); i++) {
            max_vc = Math.max(max_vc, vc.get(i) - vc.get(i-1));
        }
        long ret = (max_hc * max_vc)%100000007;
        return (int)ret;
    }
}