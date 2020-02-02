// Leetcode 1333: Filter Restaurants by Vegan-Friendly, Price and Distance
import java.util.*;

class Solution1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // TC:O(Nlog(N)), SC:O(N)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            }
        });
        
        for (int[] restaurant: restaurants) {
            if (veganFriendly == 1) {
                if (restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    pq.add(restaurant);
                }
            } else {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    pq.add(restaurant);
                }
            }
        }
        
        List<Integer> ret = new ArrayList();
        while (!pq.isEmpty()) {
            ret.add(pq.poll()[0]);
        }
        return ret;
    }
}