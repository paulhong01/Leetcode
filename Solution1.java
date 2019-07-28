// Leetcode 1: Two Sum
// Description: 
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;

        // Solution1 sol = new Solution1();
        // int[] res = sol.twoSum(nums, target);
        // for (int r: res) {
        //     System.out.printf("%d ", r);
        // }
        // System.out.println();
        int[] talent = {1,2,3,2,1};
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[talent.length];
        int talentCount = 3;
        int end = 0;
        System.out.println("haha");
        for (int i = 0; i < talent.length; i++) {
            System.out.println(talent[i]);
            while (end < talent.length && map.size() < talentCount) {
                map.put(talent[end], map.getOrDefault(talent[end], 0)+1);
                end++;
            }
            if (end == talent.length && map.size() < talentCount) {
                result[i] = -1;
            } else {
                result[i] = end - i;
            }
            
            map.put(talent[i], map.get(talent[i])-1);
            if (map.get(talent[i]) == 0) {
                map.remove(talent[i]);
            }
        }
        System.out.println(result);
        for (int r : result) {
            System.out.printf("%d ", r);
        }
        System.out.println("haha");
    }

    public int[] twoSum(int[] nums, int target) {
        // Method 1 : Brute force, TC:O(n^2), SC:O(1)
        // int[] result = new int[2];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++){
        //         if (nums[i] + nums[j] == target) {
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return result;

        // Method 2: Using Map, TC:O(1), SC:O(n)
        Map<Integer, Integer> map = new HashMap();
        int size= nums.length;
        int[] result = new int[2];
        for (int i = 0; i < size; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
} 