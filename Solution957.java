// Leetcode 957: Prison Cells After N Days
import java.util.*;

public class Solution957 {
    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        Solution957 sol = new Solution957();
        int[] res = sol.prisonAfterNDays(cells, N);
        for (int r: res) {
            System.out.printf("%d ", r);
        }
        System.out.println();
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        // Method 1: Brute force, time limit exceeded
        // for (int i = 0; i < N; i++) {
        //     int[] prev = cells.clone();
        //     cells[0] = 0;
        //     cells[cells.length - 1] = 0;
        //     for (int idx = 1; idx < cells.length - 1; idx++) {
        //         if ((prev[idx+1] == 1 && prev[idx-1] == 1) || (prev[idx+1] == 0 && prev[idx-1] == 0)) {
        //             cells[idx] = 1;
        //         } else {
        //             cells[idx] = 0;
        //         }
        //     }
        // }
        // return cells;
        
        
        // Method 2: Simulation with memorization 
        int[] prev = cells.clone();
        int cycle = 0;
        int[] newarr = new int[8];
        int[] initial = new int[8];
        while (N-- > 0) {
            newarr = new int[8];
            for (int idx = 1; idx < 7; idx++) {
                newarr[idx] = (prev[idx-1] == prev[idx+1])?1:0;
            }
            
            if (cycle == 0) {
                initial = newarr.clone();
                cycle++;
            } else if (Arrays.equals(newarr, initial)) {
                // System.out.printf("%d %d\n", N, cycle);
                // for (int i: initial) {
                //     System.out.printf("%d ", i);
                // }
                // System.out.println();
                N %= cycle;
            } else {
                cycle++;
            }
            prev = newarr;
        }
        return newarr;
    }
}