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
        // TC:O(n), SC:O(1)
        int[] count = new int[26];
        for (char t: tasks) {
            count[t - 'A']++;
        }   

        Arrays.sort(count);
        int mx = count[25], i = 25;

        while (i >= 0&& count[i] == mx) i--;

        return Math.max(tasks.length, (mx - 1)*(n + 1) + 25 - i);
    }
}