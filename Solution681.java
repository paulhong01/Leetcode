// Leetcode 681: Next Closest Time
import java.util.*;

public class Solution681 {
    public static void main(String[] args) {
        String time = "19:34";

        Solution681 sol = new Solution681();
        String res = sol.nextClosestTime(time);
        System.out.println(res);
    }

    public String nextClosestTime(String time) {
        // Method 1: Simulation
        int cur = 60 * Integer.valueOf(time.substring(0, 2));
        cur += Integer.valueOf(time.substring(3));
        Set<Character> set = new HashSet();
        for (char c: time.toCharArray()) {
            set.add(c);
        }

        while (true) {
            cur = (cur + 1)%(60*24);
            char[] temp = {(char)((cur/60/10) + '0'), (char)((cur/60%10) + '0'), (char)((cur%60/10) + '0'), (char)((cur%60%10) + '0')};
            boolean flag = true;
            for (int i = 0; i < temp.length; i++) {
                if (!set.contains(temp[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                String result = Character.toString(temp[0]) + Character.toString(temp[1]) + ":" + Character.toString(temp[2]) + Character.toString(temp[3]);
                return result;
            }
        }

    }
}