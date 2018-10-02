// Leetcode 165: Compare Version Numbers
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Solution165 {
    public static void main(String[] args) {
        String ver1 = "1", ver2 = "1.1";

        Solution165 sol = new Solution165();
        int res = sol.compareVersion(ver1, ver2);
        System.out.println(res);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int idx1 = 0, idx2 = 0;
        int len1 = v1.length, len2 = v2.length;

        while (idx1 < len1 && idx2 < len2) {
            int n1 = Integer.valueOf(v1[idx1++]);
            int n2 = Integer.valueOf(v2[idx2++]);
            if (n1 < n2) {
                return -1;
            } else if (n1 > n2) {
                return 1;
            }
        }

        while (idx1 < len1) {
            int temp = Integer.valueOf(v1[idx1]);
            if (temp == 0 && idx1 == len1 -1)    return 0;
            else if (temp == 0)  idx1++;
            else return 1;
        }  
        
        while (idx2 < len2) {
            int temp = Integer.valueOf(v2[idx2]);
            if (temp == 0 && idx2 == len2 -1)    return 0;
            else if (temp == 0)  idx2++;
            else return -1;
        }  
        return 0;
    }
}