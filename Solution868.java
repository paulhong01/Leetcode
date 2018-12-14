// Leetcode 868: Binary Gap
import java.util.*;

public class Solution868 {
    public static void main(String[] args) {
        int N = 22;
        Solution868 sol = new Solution868();
        int res = sol.binaryGap(N);
        System.out.println(res);
    }

    public int binaryGap(int N) {
        String binary = Integer.toBinaryString(N);
        int prev = -1;
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1' && prev == -1) {
                prev = i;
            } else if (binary.charAt(i) == '1') {
                result = Math.max(i - prev, result);
                prev = i;
            }
        }
        return result;
    }
}