// Leetcode 87: Scramble String
class Solution87 {
    public boolean isScramble(String s1, String s2) {
        // TC:O(2^N), SC:O(1)
        // o(n) = (o(1) + o(n -1)) + (o(2) + o(n -2)) + … + (o(n - 1) + o(1)))
        // => o(n) = 2 * (o(1) + … + o(n - 1))  
        // so o(n - 1) = 2 * (o(1) + … + o(n -2))

        // => o(n) - o(n - 1) = 2 * (o(n - 1))  //we minus o(n) and o(n - 1)
        // => o(n) = 3 * o(n - 1) = 3^2 * o(n - 2) = ...  
        // …  
        // => o(n) = 3^n that is exponential 
        if (s1.equals(s2)) {
            return true;
        }
        
        int len = s1.length();
        int[] charArray = new int[26];
        for (int i = 0; i < len; i++) {
            charArray[s1.charAt(i) - 'a']++;
            charArray[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len-i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len-i))) {
                return true;
            }
        }
        return false;
    }
}