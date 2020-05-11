// Leetcode 1436: Destination City
import java.util.*;

class Solution1436 {
    public String destCity(List<List<String>> paths) {
        // TC:O(N), SC:O(N)
        Map<String, Integer> out_degree = new HashMap<>();
        Set<String> cities = new HashSet<>();
        for (List<String> path: paths) {
            cities.add(path.get(0));
            cities.add(path.get(1));
            out_degree.put(path.get(0), out_degree.getOrDefault(path.get(0), 0)+1);
        }
        String ret = "";
        for (String city: cities) {
            if (out_degree.getOrDefault(city, 0) == 0) {
                ret = city;
            }
        }
        return ret;
    }
}