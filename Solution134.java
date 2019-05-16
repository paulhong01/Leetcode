// Leetcode 134: Gas Station
import java.util.*;

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Method 1: TC:O(N^2), SC:O(1)
        // int N = gas.length;
        // for (int i = 0; i < N; i++) {
        //     int curgas = gas[i];
        //     int curpos = i;
        //     while (true) {
        //         int nextpos = (curpos+1)%N;
        //         curgas = curgas - cost[curpos];
        //         if (curgas < 0) break;
        //         curgas += gas[nextpos];
        //         curpos = nextpos;
        //         if (curpos == i) return i;
        //     }
            
        // }
        // return -1;

        // Method 2: Greedy, TC:O(N), SC:O(1)
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
        total_tank += gas[i] - cost[i];
        curr_tank += gas[i] - cost[i];
        // If one couldn't get here,
        if (curr_tank < 0) {
            // Pick up the next station as the starting one.
            starting_station = i + 1;
            // Start with an empty tank.
            curr_tank = 0;
        }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}