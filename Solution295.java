// Leetcode 295: Find Median from Data Stream
import java.util.*;

// Method 1: List + binary search
// TC:O(n), SC:O(n)
// class MedianFinder {

//     List<Integer> list;
    
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         list = new ArrayList();
//     }
    
//     public void addNum(int num) {
//         int l = 0, r = list.size()-1;
//         while (l <= r) {
//             int m = l + (r - l)/2;
//             if (list.get(m) > num)  r = m - 1;
//             else l = m + 1;
//         }
//         // for (int n: list) {
//         //     System.out.printf("%d ", n);
//         // }
//         // System.out.printf("%d %d",l, num);
//         // System.out.println();
//         list.add(l, num);
//     }
    
//     public double findMedian() {
//         // for (int n: list) {
//         //     System.out.printf("%d ", n);
//         // }
//         // System.out.println("");
//         int m = list.size()/2;
//         if (list.size() % 2 == 0) {
//             return (list.get(m) + list.get(m-1))/2.0;
//         } else {
//             return (double)list.get(m);
//         }
//     }
// }

// Method 2: 2 heap
// TC:O(log(n)), SC:O(n)
class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue();
    boolean even = true;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (even) {
            minheap.offer(num);
            maxheap.offer(minheap.poll());
        } else {
            maxheap.offer(num);
            minheap.offer(maxheap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (minheap.peek() + maxheap.peek())/2.0;
        } else {
            return (double)maxheap.peek();
        }
    }
}