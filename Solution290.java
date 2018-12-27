// Leetcode 290: Word Pattern
import java.util.*;

class Solution290 {
    public static void main(String[] args) {
        Solution290 sol = new Solution290();
        if (sol.wordPattern("abba", "dog dog dog dog")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean wordPattern(String pattern, String str) {
        // Method 1:
        // TC:O(n), SC:O(n)
        // String[] str_arr = str.split(" ", -1);
        // if (pattern.length() != str_arr.length) return false;
        
        // int len = pattern.length();
        // Map<Character, String> mapchar = new HashMap();
        // Map<String, Character> mapstring = new HashMap();
        // for (int i = 0; i < len; i++) {
        //     if (!mapchar.containsKey(pattern.charAt(i)) && !mapstring.containsKey(str_arr[i])) {
        //         mapchar.put(pattern.charAt(i), str_arr[i]);
        //         mapstring.put(str_arr[i], pattern.charAt(i));
        //     } else {
        //         String value = mapchar.getOrDefault(pattern.charAt(i), " ");
        //         char stringvalue = mapstring.getOrDefault(str_arr[i], ' ');
        //         if (!value.equals(str_arr[i]) || stringvalue != pattern.charAt(i))  return false;
        //     }
        // }
        // return true;

        // Method 2: 
        String[] str_arr = str.split(" ", -1);
        if (pattern.length() != str_arr.length) return false;
        
        int len = pattern.length();
        Map<Character, String> mapchar = new HashMap();
        for (int i = 0; i < len; i++) {
            if (!mapchar.containsKey(pattern.charAt(i))) {
                if (mapchar.containsValue(str_arr[i]))  return false;
                mapchar.put(pattern.charAt(i), str_arr[i]);
            } else {
                String value = mapchar.getOrDefault(pattern.charAt(i), " ");
                if (!value.equals(str_arr[i]))  return false;
            }
        }
        return true;
    }
}
