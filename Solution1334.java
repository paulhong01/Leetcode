// Leetcode 1334: Find the City With the Smallest Number of Neighbors at a Threshold Distance
import java.util.*;

class Solution1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Floyd Algorithm, TC:O(N^3), SC:O(N^2)
        int[][] distance = new int[n][n];
        for (int[] row: distance) {
            Arrays.fill(row, 10001);
        }
        for (int[] edge: edges) {
            distance[edge[0]][edge[1]] = distance[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        
        int ret = 0, min_count = 10001;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= min_count) {
                ret = i;
                min_count = count;
            }
        }
        return ret;
        
    }
}
