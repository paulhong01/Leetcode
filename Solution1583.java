// Leetcode 1583: Count Unhappy Friends
import java.util.*;

class Solution1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // TC:O(N^2), SC:O(N)
        int[] map = new int[n];
        for(int[] pair: pairs){ // Keep record of current matches.
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        int res = 0;
		
        Map<Integer, Integer>[] prefer = new Map[n]; // O(1) to fetch the index from the preference array. 
         
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(prefer[i] == null) prefer[i] = new HashMap<>();
                prefer[i].put(preferences[i][j], j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j : preferences[i]){
                if(prefer[j].get(i) < prefer[j].get(map[j]) 
					&& prefer[i].get(map[i]) > prefer[i].get(j)){ // Based on the definition of "unhappy"...
                    res++;
                    break;
                }
            }
        }
	    return res;
    }
}
