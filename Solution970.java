// Leetcode 970
import java.util.*;

class Solution970 {
    public static void main(String[] args) {
        int x = 2, y = 3, bound = 10;
        Solution970 sol = new Solution970();
        List<Integer> res = sol.powerfulIntegers(x, y, bound);
        for (int r: res) {
            System.out.printf("%d ", r);
        }
        System.out.println();
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        // TC:O(log^2(bound)), SC:O(log^2(bound))
        Set<Integer> set = new HashSet();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}