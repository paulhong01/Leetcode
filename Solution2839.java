// Leetcode 2839: Check if Strings Can be Made Equal With Operations I

class Solution2839 {
    public boolean canBeEqual(String s1, String s2) {
        // TC:O(N), SC:O(N)
        if (s1.equals(s2)) {
            return true;
        }

        String swap_first = swap(s1.toCharArray(), 0, 2);
        if (swap_first.equals(s2)) {
            return true;
        }
        if (swap(swap_first.toCharArray(), 1, 3).equals(s2)) {
            return true;
        }
        if (swap(s1.toCharArray(), 1, 3).equals(s2)) {
            return true;
        }
        return false;
    }

    private String swap(char[] str, int idx1, int idx2) {
        char temp = str[idx1];
        str[idx1] = str[idx2];
        str[idx2] = temp;
        return String.valueOf(str);
    }
}
