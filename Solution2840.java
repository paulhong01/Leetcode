// Leetcode 2840: Check if Strings Can be Made Equal With Operations II

class Solution2840 {
    public boolean checkStrings(String s1, String s2) {
        // TC:O(N), SC:O(1)
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i += 2) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i += 2) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
