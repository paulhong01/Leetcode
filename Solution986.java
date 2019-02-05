// Leetcode 986: Interval List Intersections
import java.util.*;

class Solution986 {
    class sortInterval implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start != b.start) return a.start - b.start;
            else    return a.end - b.end;
        }
    }
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        // If the order is sorted: TC:O(M+N), SC:O(M+N)
//         List<Interval> result = new ArrayList();
//         int i = 0, j = 0;
        
//         while (i < A.length && j < B.length) {
//             int l = Math.max(A[i].start, B[j].start);
//             int h = Math.min(A[i].end, B[j].end);
            
//             if (l <= h) {
//                 result.add(new Interval(l, h));
//             } 
//             if (A[i].end < B[j].end) {
//                 i++;
//             } else {
//                 j++;
//             }  
//         }
//         return result.toArray(new Interval[result.size()]);
        
        // If the order is not sorted
        List<Interval> Alist = Arrays.asList(A);
        List<Interval> Blist = Arrays.asList(B);
        // Collections.sort(Alist, new Comparator<Interval>() {
        //     public int compare(Interval a, Interval b) {
        //         if (a.start != b.start) return a.start - b.start;
        //         else return a.end - b.end;
        //     }
        // } );
        // Collections.sort(Blist, new Comparator<Interval>() {
        //    public int compare(Interval a, Interval b) {
        //        if (a.start != b.start) return a.start - b.start;
        //        else return a.end - b.end;
        //    } 
        // });
        Collections.sort(Alist, new sortInterval());
        Collections.sort(Blist, new sortInterval());
        
        List<Interval> result = new ArrayList();
        int i = 0, j = 0;
        
        while (i < A.length && j < B.length) {
            int l = Math.max(Alist.get(i).start, Blist.get(j).start);
            int h = Math.min(Alist.get(i).end, Blist.get(j).end);
            
            if (l <= h) {
                result.add(new Interval(l, h));
            } 
            if (Alist.get(i).end < Blist.get(j).end) {
                i++;
            } else {
                j++;
            }  
        }
        return result.toArray(new Interval[result.size()]);
    }
}