// Leetcode 621: Task Scheduler
import java.util.*;

public class Solution621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        Solution621 sol = new Solution621();
        int res = sol.leastInterval(tasks, n);
        System.out.println(res);
    }

    public int leastInterval(char[] tasks, int n) {
        // Method 1 : PriorityQueue, TC:O(n), SC:O(1) 
        // int[] map = new int[26];
        // for (char task : tasks) {
        //     map[task - 'A']++;
        // }
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for (int i = 0; i < 26; i++) {
        //     if (map[i] > 0) pq.add(map[i]);
        // }
        // int result = 0;
        // while (!pq.isEmpty()) {
        //     List<Integer> record = new ArrayList();
        //     int count = 0;
        //     while (count <= n) {
        //         if (!pq.isEmpty()) {
        //             int cur = pq.poll();
        //             if (cur-1 > 0) {
        //                 record.add(cur-1);
        //             }
        //         }
        //         count++;
        //         result++;
        //         if (record.size() == 0 && pq.isEmpty()) {
        //             break;
        //         }
        //     }
        //     for (int r: record) {
        //         pq.add(r);
        //     }
        // }
        // return result;
        
        // Method 2: Calculate idle slots, TC:O(n), SC:O(1)
        int[] map = new int[26];
        for (char task : tasks) {
            map[task-'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25]-1, idle_slots = max_val*n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
    }
}