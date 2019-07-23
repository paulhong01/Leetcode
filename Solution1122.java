// Leetcode 1122: Relative Sort Array
import java.util.*;

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // TC:O(1), SC:O(M+N), M = arr1.length, N = arr2.length
        int[] map = new int[1001];
        for (int n : arr1) {
            map[n]++;
        }
        
        int idx = 0;
        for (int key: arr2) {
            int size = map[key];
            for (int count = 0; count < size; count++) {
                arr1[idx++] = key;
                map[key]--;
            }
        }
        
        for (int i = 0; i <= 1000; i++) {
            if (map[i] != 0) {
                int size = map[i];
                for (int count = 0; count < size; count++) {
                    arr1[idx++] = i;
                    map[i]--;
                }
            }
        }
        return arr1;
    }
}