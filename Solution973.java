// Leetcode 973: K Closest Points to Origin
import java.util.*;

class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }   
        });
        
        for (int[] point: points) {
            int dist = point[0]*point[0] + point[1]*point[1];
            pq.add(new int[]{point[0], point[1], dist});
        }
        
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] data = pq.poll();
            result[i][0] = data[0];
            result[i][1] = data[1];
        }
        return result;
    }
}