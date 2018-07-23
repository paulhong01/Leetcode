//Leetcode 406 : Queue Reconstruction by Height
import java.util.*;

public class Solution406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        Solution406 sol = new Solution406();
        int[][] res = sol.reconstructQueue(people);
        for (int[] i: res) {
            for (int r: i){
                System.out.printf("%d ", r);
            }
            System.out.println("");
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        // TC:O(nlog(n)), SC:O(n), since the time complexiyt of sort function is O(nlog(n))
        // Sort the people by h and k.
        Arrays.sort(people, new Comparator<int[]> () {
            public int compare(int[] n1, int[] n2) {
                if (n1[0] == n2[0]) {
                    return Integer.compare(n1[1], n2[1]);
                }
                return Integer.compare(n2[0], n1[0]);
            }
        });

        // Push the result to temparily list
        List<int[]> temp = new ArrayList<int[]> ();
        for (int[] p: people) {
            temp.add(p[1], p);
        }

        // Convert list to array
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            result[i] = temp.get(i);
        }
        
        return result;
    }
} 