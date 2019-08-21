// Leetcode 599: Minimum Index Sum of Two Lists
import java.util.*;

class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // TC:O(L1+L2), SC:O(L1*x), x refers to average string length
        Map<String, Integer> idx_map = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            idx_map.put(list1[i], i);
        }
        int min_sum = list1.length+list2.length;
        List<String> min_list = new ArrayList();
        for (int i = 0; i < list2.length; i++) {
            if (idx_map.containsKey(list2[i])) {
                int idx_sum = i + idx_map.get(list2[i]);
                if (idx_sum < min_sum) {
                    min_sum = idx_sum;
                    min_list.clear();
                    min_list.add(list2[i]);
                } else if (idx_sum == min_sum) {
                    min_list.add(list2[i]);
                }
            }
        }
        String[] ret = new String[min_list.size()];
        for (int i = 0; i < min_list.size(); i++) {
            ret[i] = min_list.get(i);
        }
        return ret;
    }
}