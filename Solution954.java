// Leetcode 954: Array of Doubled Pairs
class Solution {
    public boolean canReorderDoubled(int[] A) {
        // Idea: check every possible solution
        // TC:O(200000), SC:O(200000)
        int gap = 100000;
        int[] dict = new int[2*gap+1];
        for (int n: A) {
            dict[n+gap]++;
        }
        
        // check 0
        if (dict[gap] % 2 != 0) return false;
        // check negative
        for (int i = -1; i >= -1*gap/2; i--) {
            if (dict[i + gap] != 0) {                
                if (dict[2*i+gap] < dict[i+gap] )    return false;
                else {
                    dict[2*i+gap] -= dict[i+gap];
                }
                dict[i+gap] = 0;
            }
        }
        
        // check positive
        for (int i = 1; i <= gap/2; i++) {
            if (dict[i + gap] != 0) {
                if (dict[2*i+gap] < dict[i+gap])    return false;
                else {
                    dict[2*i+gap] -= dict[i+gap];
                }
                dict[i+gap] = 0;
            }
        }
        return true;
    }
}