// Leetcode 2844: Minimum Operations to Make a Special Number

class Solution2844 {
    public int minimumOperations(String num) {
        // TC:O(1), SC:O(1)
        int min_operations = num.length();
        ArrayList<List<Character>> types = new ArrayList<List<Character>>();
        types.add(Arrays.asList('0', '0'));
        types.add(Arrays.asList('2', '5'));
        types.add(Arrays.asList('5', '0'));
        types.add(Arrays.asList('7', '5'));
        for (List<Character> end : types) {
            int operations = OperationsToReachEnd(num, end);
            min_operations = Math.min(min_operations, operations);
        }
        return min_operations;
    }

    private int OperationsToReachEnd(String num, List<Character> end) {
        int count = 0, end_idx = 1;
        for (int i = num.length()-1; i >= 0; --i) {
            if (end_idx < 0) {
                break;
            }

            if (num.charAt(i) == end.get(end_idx)) {
                --end_idx;
            } else {
                ++count;
            }
        }
        if (end_idx >= 0 && end.get(0) != '0') {
            return num.length();
        }
        return count;
    }
}