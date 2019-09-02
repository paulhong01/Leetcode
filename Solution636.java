// Leetcode 636: Exclusive Time of Functions
import java.util.*;

class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Stack: TC:O(N), SC:O(N)
        Stack<Integer> stack = new Stack();
        int[] time = new int[n];
        String[] start = logs.get(0).split(":");
        int cur_id = Integer.valueOf(start[0]);
        int cur_time = Integer.valueOf(start[2]);
        for (int i = 1; i < logs.size(); i++) {
            String[] temp_time = logs.get(i).split(":");
            if (temp_time[1].equals("end")) {
                time[cur_id] += (Integer.valueOf(temp_time[2])-cur_time+1);
                cur_id = stack.size()>0?stack.pop():-1;
                cur_time = Integer.valueOf(temp_time[2])+1;
            } else if (cur_id == -1 && temp_time[1].equals("start")) {
                cur_id = Integer.valueOf(temp_time[0]);
                cur_time = Integer.valueOf(temp_time[2]);
            } else {
                time[cur_id] += (Integer.valueOf(temp_time[2])-cur_time);
                stack.push(cur_id);
                cur_id = Integer.valueOf(temp_time[0]);
                cur_time = Integer.valueOf(temp_time[2]);
            }
        }
        return time;
    }
}