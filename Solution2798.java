// Leetcode 2798: Number of Employees Who Met the Target

class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        // TC:O(N), SC:O(1)
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                ++count;
            }
        }
        return count;
    }
}
