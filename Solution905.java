class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[idx++] = A[i];
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                result[idx++] = A[i];
            }
        }
        return result;
    }
}