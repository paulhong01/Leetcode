// Leetcode 75: Sort Colors
import java.util.*;

public class Solution75 {
    public static void main(String[] args) {
        // int[] nums = {2,0,2,1,1,0};
        int[] nums = {2, 0, 1};

        Solution75 sol = new Solution75();
        sol.sortColors(nums);
        for (int n: nums) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }

    
public void sortColors(int[] nums) {
        // Method 1: Bubble sort, TC:O(n^2), SC:O(1)
        /* for (int count = 0; count < nums.length - 1; count++) {
            for (int idx = 0; idx < nums.length - count - 1; idx++) {
                if (nums[idx + 1] < nums[idx]) {
                    int temp = nums[idx];
                    nums[idx] = nums[idx + 1];
                    nums[idx + 1] = temp;
                }
            }
        }    
        return; */

        // Method 2: Selection sort, TC:O(n^2), SC:O(1)
        /* for (int i = 0; i < nums.length; i++) {
            int minidx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minidx] > nums[j]) {
                    minidx = j;
                }
            }
            int temp = nums[minidx];
            nums[minidx] = nums[i];
            nums[i] = temp;
        }
        return; */

        // Method 3: Quick sort, TC:O(n^2), SC:O(log(n))
        /* quickSort(nums, 0, nums.length - 1); */

        // Method 4: Merge sort, TC:O(nlog(n)), SC:O(n)
        /* mergeSort(nums, 0, nums.length - 1); */

        // Method 5: two pass, TC:O(n), SC:O(1)
        /* int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;
        }
        int idx = 0;
        while (count0-- > 0)  nums[idx++] = 0;
        while (count1-- > 0)  nums[idx++] = 1;
        while (count2-- > 0)  nums[idx++] = 2;
        return; */

        // Method 6: one pass, TC:O(n), SC:O(1), Reference: https://leetcode.com/problems/sort-colors/discuss/26474/Sharing-C++-solution-with-Good-Explanation
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int countl = mid - l + 1, countr = r - mid;
        int[] L = new int[countl];
        int[] R = new int[countr];
        for (int i = 0; i < countl; i++) {
            L[i] = nums[l + i];
        }
        for (int i = 0; i < countr; i++) {
            R[i] = nums[mid + 1 + i];
        }

        for (int i = l, idxl = 0, idxr = 0; i <= r; i++) {
            if (idxl < countl && idxr < countr) {
                nums[i] = (L[idxl] < R[idxr])?(L[idxl++]):(R[idxr++]);
            } else if (idxl < countl) {
                nums[i] = L[idxl++];
            } else {
                nums[i] = R[idxr++];
            }
        }

    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }
    }

    private int partition(int[] nums, int l , int r) {
        int pivot = nums[r];
        int idx = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                if (nums[idx] != nums[i]) {
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                }
                idx++;
            }
        }

        int temp = nums[idx];
        nums[idx] = pivot;
        nums[r] = temp;
        return idx;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivotidx = partition(nums, l, r);
            quickSort(nums, l, pivotidx - 1);
            quickSort(nums, pivotidx + 1, r);
        }
    }
}