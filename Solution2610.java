// Leetcode 2610: Convert an Array Into a 2D Array With Conditions

public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] A) {
        // TC:O(N), SC:O(N)
        ArrayList<List<Integer>> res = new ArrayList<>();
        int n = A.length, count[] = new int[n + 1];
        for (int a : A) {
            if (res.size() < ++count[a])
                res.add(new ArrayList<>());
            res.get(count[a]).add(a);
        }
        return res;
    }
}
