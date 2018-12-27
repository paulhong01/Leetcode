// Leetcode 556: Next Greater Element III
import java.util.*;

class Solution556 {
    
    public static void main(String[] args) {
        int n = 230241;
        Solution556 sol = new Solution556();
        int result = sol.nextGreaterElement(n);
        System.out.println(result);
    }

    public int nextGreaterElement(int n) {
        // Method 1: Brute force 
        // TC:O(n), SC:O(1)
        // int[] record = new int[10];
        // int count = getRecord(n, record);
        
        // for (int i = n + 1; i < Math.pow(10, count); i++) {
        //     if (check(i, record)) return i;
        // }
        // return -1;

        // Method 2: Next permutation
        // TC:O(n), SC:O(1)
        char[] num = String.valueOf(n).toCharArray();
        int pivot = -1;
        for (int i = num.length - 1; i >= 1; i--) {
            if (num[i-1] < num[i]) {
                pivot = i - 1;
                break;
            }
        }
        if (pivot == -1) return -1;

        // Reverse
        reverse(num, pivot + 1);

        // Swap pivot with the first element that larger than pivot
        int nextpivot = -1;
        for (int i = pivot + 1; i < num.length; i++) {
            if (num[i] > num[pivot]) {
                nextpivot = i;
                break;
            }
        }
        char temp = num[nextpivot];
        num[nextpivot] = num[pivot];
        num[pivot] = temp;

        long result = Long.valueOf(String.valueOf(num));
        // System.out.println(result);
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }

    private void reverse(char[] num, int start) {
        int end = num.length - 1;
        while (start < end) {
            char temp = num[start];
            num[start++] = num[end];
            num[end--] = temp;
        }
    }
    
    private int getRecord(int n, int[] record) {
        int count = 0;
        while (n > 0) {
            record[n%10]++;
            n = n/10;
            count++;
        }
        return count;
    }
    
    private boolean check(int n, int[] record) {
        int[] temprecord = record.clone();
        
        while (n > 0) {
            temprecord[n%10]--;
            if (temprecord[n%10] < 0)   return false;
            n = n/10;
        }
        
        for (int i = 0; i < 10; i++) {
            if (temprecord[i] != 0) return false;
        }
        return true;
    }
}