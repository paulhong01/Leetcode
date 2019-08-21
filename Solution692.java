// Leetcode 692: Top K Frequent Words
import java.util.*;

class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        // Method 1: max-heap, TC:O(Nlog(N)), SC:O(N)
        // Map<String, Integer> freq = new HashMap();
        // for (String word : words) {
        //     freq.put(word, freq.getOrDefault(word, 0)+1);
        // }
        // List<String> list = new ArrayList(freq.keySet());
        // Collections.sort(list, new Comparator<String>() {
        //    public int compare(String a, String b) {
        //        if (freq.get(a) != freq.get(b)) {
        //             return freq.get(b)-freq.get(a);          
        //        } else {
        //            return a.compareTo(b);
        //        }
        //    } 
        // });
        // List<String> res = new ArrayList();
        // for (int i = 0; i < k; i++) {
        //     res.add(list.get(i));
        // }
        // return res;
        
        // Method 2: min-heap, TC:O(Nlog(K)), SC:(N)
        Map<String, Integer> freq = new HashMap();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>() {
            public int compare(String a, String b) {
                if (freq.get(a) != freq.get(b)) {
                    return freq.get(a)-freq.get(b);
                } else {
                    return b.compareTo(a);
                }
            }
        });
        for (String word : freq.keySet()) {
            pq.add(word);
            if (pq.size() > k)  pq.poll();
        }
        List<String> res = new ArrayList();
        while (!pq.isEmpty())   res.add(pq.poll());
        Collections.reverse(res);
        return res;
        
    }
}