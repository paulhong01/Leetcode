// Leetcode 1007:  Minimum Domino Rotations For Equal Row
import java.util.*;

class Solution1007 {
    public int minDominoRotations(int[] A, int[] B) {
        // A
        int Amin = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            int idx;
            for (idx = 0; idx < A.length; idx++) {
                if (A[idx] != i) {
                    if (B[idx] == i) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (idx == A.length) {
                Amin = Math.min(Amin, count);
            }
        }
        
        // B 
        int Bmin = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            int idx;
            for (idx = 0; idx < B.length; idx++) {
                if (B[idx] != i) {
                    if (A[idx] == i) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (idx == B.length) {
                Bmin = Math.min(Bmin, count);
            }
        }
        
        return (Amin == Integer.MAX_VALUE && Bmin == Integer.MAX_VALUE)?-1:(Amin < Bmin?Amin:Bmin);
    }
}