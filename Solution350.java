// Leetcode 350. Intersection of Two Arrays II
import java.util.*;

public class Solution350{
    public static void main(String args[]){
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        Solution350 s = new Solution350();
        int[] result = s.intersect(nums1, nums2);
        for (int n: result)
            System.out.printf("%d ", n);
        System.out.println("");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // TC: O(max(n1, n2)) SC: O(n1), where n1 = nums1.length, n2 = nums2.length
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < nums1.length; i++){
            int val = m.getOrDefault(nums1[i], 0);
            m.put(nums1[i], val+1);
        }

        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums2.length; i++){
            int val = m.getOrDefault(nums2[i], 0);
            if (val != 0){
                result.add(nums2[i]);
                val--;
                m.put(nums2[i], val);
            }
        }

        int r[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            r[i] = result.get(i);

        return r;
    }
}