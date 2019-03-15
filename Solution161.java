// Leetcode 161: One Edit Distance
import java.util.*;

class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
       int slen = s.length(), tlen = t.length();
        if (Math.abs(slen - tlen) >= 2) return false;
        else if (slen < tlen) {
            String temp = s;
            s = t;
            t = temp;
            slen = s.length();
            tlen = t.length();
        }
        
        int count = 0;
        int idxs = 0, idxt = 0;
        
        // Delete
        while (idxs < slen && idxt < tlen) {
            if (s.charAt(idxs) == t.charAt(idxt)) {
                idxs++;
                idxt++;
            } else {
                if (count >= 1) {
                    return false;
                } else if (idxs+1 < slen && s.charAt(idxs+1) == t.charAt(idxt)) {
                    count += 1;
                    idxs++;
                } else if (idxs+1<slen && idxt+1 < tlen && s.charAt(idxs+1) == t.charAt(idxt+1)) {
                    count += 1;
                    idxs++;
                    idxt++;
                } else if (idxs+1 == slen && idxt+1 == tlen && count == 0) {
                    count += 1;
                    idxs++;
                    idxt++;
                } else {
                    count += 1;
                    idxs++;
                }
            }
        }
        
        
        return ((count==1 && idxs == slen && idxt == tlen) || (Math.abs((slen-idxs)-(tlen-idxt)) == 1 && count == 0));
        
    }
}