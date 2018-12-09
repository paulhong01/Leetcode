// Leetcode 955: Delete Columns to Make Sorted II

class Solution {
    public int minDeletionSize(String[] A) {
        // TC:O(NW^2), SC:O(NW)
        int N = A.length;
        int W = A[0].length();
        int result = 0;
        
        String[] cur = new String[N];
        
        for (int i = 0; i < W; i++) {
            
            String[] temp = Arrays.copyOf(cur, N);
            for (int j = 0; j < N; j++) {
                temp[j] += A[j].charAt(i);
            }
            
            if (check(temp)) {
                cur = temp;
            } else {
                result++;
            }
        }
        return result;
    }
    
    private boolean check(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) return false;
        }
        return true;
    }
}