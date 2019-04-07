// Leetcode 1024: Video Stitching
import java.util.*;

class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        // TC:O(nlog(n)), SC:O(n)
        Arrays.sort(clips, new Comparator<int[]>() {
            public int compare(int[] a,int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
        
        //   for(int[] c: clips) {
        //     System.out.printf("%d %d\n", c[0], c[1]);
        // }
        int N = clips.length;
        if (clips[0][0] != 0 || clips[N-1][1] < T)   return -1;
        Stack<int[]> stack = new Stack();
        stack.push(clips[0]);
        if (clips[0][1] >= T)   return 1;
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && clips[i][0] <= stack.peek()[0] && clips[i][1] > stack.peek()[1]) {
                stack.pop();
            } 
            if (stack.isEmpty() || (clips[i][0] <= stack.peek()[1] && clips[i][1] >stack.peek()[1])) {
                int start = stack.isEmpty()?clips[i][0]:Math.max(clips[i][0], stack.peek()[1]);
                int[] insert = {start, clips[i][1]};
                stack.push(insert);
                if (insert[1] >= T) break;
            } 
        }
        
        return stack.peek()[1] >= T?stack.size():-1;
    }
}