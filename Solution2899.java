// Leetcode 2899: Last Visited Integers

class Solution2899 {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        // TC:O(N), SC:O(N)
        List<Integer> cur_list = new ArrayList<Integer>();
        List<Integer> ret_list = new ArrayList<Integer>();
        int prev_count = 0;
        for (String word : words) {
            if (word.equals("prev")) {
                ++prev_count;
                if (prev_count > cur_list.size()) {
                    ret_list.add(-1);
                } else {
                    ret_list.add(cur_list.get(cur_list.size()-prev_count));
                }
            } else {
                prev_count = 0;
                int input = Integer.parseInt(word);
                cur_list.add(input);
            }
        }
        return ret_list;
    }
}
