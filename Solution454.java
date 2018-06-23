import java.util.*;


class Solution454{
    public static void main(String args[]){
        int A[] = {1, 2};
        int B[] = {-2, -1};
        int C[] = {-1, 2};
        int D[] = {0, 2};
        Solution454 s = new Solution454();
        int result = s.fourSumCount(A, B, C, D);
        System.out.println(Integer.toString(result));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> m = new HashMap();
        int size = A.length;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int key = A[i] + B[j];
                int temp_value = m.getOrDefault(key, 0) + 1;
                m.put(key, temp_value);
            }
        }
        int result = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int key = -C[i]-D[j];
                int key_temp = m.getOrDefault(key, 0);
                result += key_temp;
            }
        }

        return result;
    }
}