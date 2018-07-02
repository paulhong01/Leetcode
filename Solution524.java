// Leetcode 524: Longest Word in Dictionary through Deleting
import java.util.*;

public class Solution524{
    public static void main(String[] args){
        //String s = "abpcplea";
        //String[] d_temp = {"ale","apple","monkey","plea"};
        //String[] d_temp = {"a", "b", "c"};
        String s = "aaa";
        String[] d_temp = {"aaa","aa","a"};
        List<String> d = Arrays.asList(d_temp);
        Solution524 sol = new Solution524();
        String result = sol.findLongestWord(s, d);
        System.out.println(result);
    }

    public String findLongestWord(String s, List<String> d) {
        // Like leetcode 392, prepossing String s first, then checking whether String in d satisfies the order using binary search
        // TC: O:(ns+nd*log(ns)), SC:O(ns), where ns = s.length(), nd = d.size()
        // Prepossing s
        Map<Character, List<Integer>> map = new HashMap();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            map.putIfAbsent(cur, new ArrayList<Integer>());
            map.get(cur).add(i);
        }

        String result = "";
        for (String s_in: d){
            if(checker(s_in, map)){
                if (s_in.length() > result.length()){
                    result = s_in;
                } else if (s_in.length() == result.length() && s_in.charAt(0) < result.charAt(0)){
                    result = s_in;
                }
            }
        }
        return result;
    }

    private boolean checker(String s_in, Map<Character, List<Integer>> map){
        int prev = -1;
        for (int i = 0; i < s_in.length(); i++){
            char cur = s_in.charAt(i);
            List<Integer> list = map.getOrDefault(cur, null);
            if (list == null)
                return false;
            prev = binarySearch(prev, list);
            if (prev == -1)
                return false;
        }
        return true;
    }

    private int binarySearch(int pos, List<Integer> list){
        int l = 0, r = list.size() - 1;
        while (l < r){
            int mid = l + (r - l)/2;
            if (list.get(mid) > pos){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return list.get(l) >= pos?list.get(l):-1;
    }
}