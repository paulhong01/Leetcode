// Leetcode 1899: Merge Triplets to Form Target Triplet
import java.util.*;

class Solution1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // TC:O(N), SC:O(1)
        int[] res = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                res = new int[] {Math.max(triplet[0], res[0]), Math.max(triplet[1], res[1]), Math.max(triplet[2], res[2])};
            }
        }
        return Arrays.equals(res, target);
    }
}
