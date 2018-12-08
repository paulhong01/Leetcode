class Solution945 {
    public int minIncrementForUnique(int[] A) {
        // Solution 1: Brute force
        int[] record = new int[40001];
        for (int n: A) {
            record[n]++;
        }
        int result = 0;
        for (int i = 0; i < 40001; i++) {
            int size = record[i];
            int j = i + 1;
            while (size > 1) {
                // System.out.printf("%d %d\n", i, size);
                for (; j < 40001; j++) {
                    if (record[j] < 1) {
                        record[j] = 1;
                        result += (j - i);
                        size--;
                        break;
                    }
                }
            }
        }
        
        return result;
       
        // Solution 2: sort and then compare 
        // TC:O(nlog(n)), SC:O(1)
        Arrays.sort(A);
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                result += A[i-1] - A[i] + 1;
                A[i] = A[i-1] + 1;
            }
        }
        return result;
    }
}