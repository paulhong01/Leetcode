// Leetcode 2843: Count Symmetric Integers

class Solution2843 {
    public int countSymmetricIntegers(int low, int high) {
        // TC:O(N), SC:O(N)
        int count = 0;
        for (int i = low; i <= high; i++) {
            if(isSymmetric(i)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isSymmetric(int value) {
        String value_str = Integer.toString(value);
        if (value_str.length()%2 != 0) {
            return false;
        }

        int front_idx = 0, back_idx = value_str.length() - 1;
        int front_count = 0, back_count = 0;
        while (front_idx < back_idx) {
            front_count += (value_str.charAt(front_idx) - '0');
            back_count += (value_str.charAt(back_idx) - '0');
            ++front_idx;
            --back_idx;
        }
        return (front_count == back_count);
    }
}
