// Leetcode 6: ZigZag Conversion
import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution6 sol = new Solution6();
        String res = sol.convert(s, numRows);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        // TC:O(n), SC:O(n)
        if (numRows <= 1)  return s;

        List<StringBuilder> list = new ArrayList();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int curidx = 0;
        boolean down = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(curidx).append(s.charAt(i));
            if (curidx == numRows - 1 || curidx == 0) down = !down;
            curidx += (down)?1:-1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder l: list) {
            result.append(l);
        }
        return result.toString();
    }
}