// Leetcode 338: Counting Bits
import java.util.*;

public class Solution338{
    public static void main(String[] args){
        int num = 5;
        Solution338 s = new Solution338();
        int[] result = s.countBits(num);
        for (int i: result) System.out.printf("%d ", i);
        System.out.println("");
    }

    public int[] countBits(int num) {
        // f[i] = f[i/2] + i%2, TC:O(n), SC:O(1)
        int result[] = new int [num+1];
        for (int i = 1; i <= num; i++){
            result [i] = result[i/2] + (i & 1);
        }
        return result;
    }
}