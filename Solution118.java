// Leetcode 118: Pascal's Triangle
import java.util.*;

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList();
        temp.add(1);
        result.add(temp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList();
            cur.add(1);
            int last_size = result.get(i-1).size();
            for (int j = 1; j < last_size; j++) {
                cur.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
            }
            cur.add(1);
            result.add(new ArrayList(cur));
        }
        return result;
    }
}