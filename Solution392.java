// Leetcode 392: Is Subsequence
import java.util.*;

public class Solution392{
    public static void main(String args[]){
        String s = "abc", t = "ahbgdc";
        //String s = "axc", t = "ahbgdc";
        Solution392 sol = new Solution392();
        boolean result = sol.isSubsequence(s, t);
        if (result)
            System.out.println("True");
        else 
            System.out.println("False");
    }

    public boolean isSubsequence(String s, String t) {
        // Method 1 : Iterative TC:O(n2) SC:O(1), where n2 = t.length()
        /*
        if (s.length() > t.length())
            return false;
        else if (s.length() == 0)
            return true;

        int index = 0;
        for (int i = 0; i < t.length(); i++){
            if (s.charAt(index) == t.charAt(i))
                index++;
            if (index == s.length())
                return true;
        }

        return false;
        */

        // Method 2: prepossing String t first, and then check string s
        if (s.length() > t.length())
            return false;
        else if (s.length() == 0)
            return true;
        // Prepossing t
        Map<Character, List<Integer>> m = new HashMap();
        for (int i = 0; i < t.length(); i++){
            char cur = t.charAt(i);
            if (m.get(cur) == null)
                m.put(cur, new ArrayList<Integer> ());
            m.get(cur).add(i);
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (m.get(cur) == null)
                return false;
            else{
                List<Integer> list = m.get(cur);
                prev = binarySearch(prev, list, 0, list.size()-1);
                if (prev == -1)
                    return false;
                prev++;
            }
        }

        return true;
    }

    public int binarySearch(int index, List<Integer> list, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if (list.get(mid) < index){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start == list.size()?-1:list.get(start);
    }
}