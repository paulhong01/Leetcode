// Leetcode 1338: Reduce Array Size to The Half
import java.util.*;

class Solution1338 {
    public int minSetSize(int[] arr) {
            // Solution 1: Sorting, TC:O(Nlog(N)), SC:O(N)
//         Arrays.sort(arr);
//         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return b[1] - a[1];
//            } 
//         });
        
//         int count = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if (i != 0 && arr[i] != arr[i-1]) {
//                 int[] temp = {arr[i-1], count};
//                 pq.add(temp);
//                 count = 1;
//             } else {
//                 count++;
//             }
//         }
//         int[] temp = {arr[arr.length-1], count};
//         pq.add(temp);
        
//         count = 0;
//         int ret = 0;
//         while (count < arr.length/2) {
//             ret++;
//             count += pq.poll()[1];
//         }
//         return ret;
        
        // Solution 2: TC:O(N), SC:O(N)
        // Count the numbers' frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr) {
            int freq_count = freq.getOrDefault(a, 0)+1;
            freq.put(a, freq_count);
        }
        
        // Create an array of lists, with the frequency being the key, the numbers with that frequency in the list.
        List<Integer>[] list = new ArrayList[arr.length+1];
        for (int num: freq.keySet()) {
            int freq_count = freq.get(num);
            if (list[freq_count] == null) {
                list[freq_count] = new ArrayList();
            }
            list[freq_count].add(num);
        }
        
        // Count backwards, return once half size is reached.
        int count = 0;
        int ret = 0;
        for (int i = arr.length; i >= 0; i--) {
            List<Integer> cur = list[i];
            if (cur == null || cur.size() == 0) {
                continue;
            }
            for (int c: cur) {
                ret++;
                count += i;
                if (count >= arr.length/2) {
                    return ret;
                }
            }
        }
        return ret;
        
        
    }
}