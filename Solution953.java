//Leetcode 953: Verifying an Alien Dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // TC:O(n), SC:O(1)
        int[] dict = new int[26];
        for (int i = 0; i < 26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 1; i < words.length; i++) {
            if (!compareString(words[i-1], words[i], dict))  return false;
        }
        
        return true;
    }
    
    private boolean compareString(String a, String b, int[] dict) {
        // 1. a.length == b.length
        // 2. a.length < b.length => return true
        // 3. a.length > b.length => return false;
        int len = a.length() <= b.length()?a.length():b.length();
        for (int i = 0; i < len; i++) {
            if (dict[a.charAt(i) - 'a'] < dict[b.charAt(i) - 'a'])  return true;
            else if (dict[a.charAt(i) - 'a'] > dict[b.charAt(i) - 'a'])  return false;
        }
        return a.length() <= b.length();
    }
}