// Leetcode 1710: Maximum Units on a Truck
import java.util.*;

public class Solution1710 {
    public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        // TC:O(Nlog(N)), SC:O(1)
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& box_a, const vector<int> box_b){
           return box_a[1] > box_b[1]; 
        });
        int ret = 0;
        int num_truck_left = truckSize;
        for (int i = 0; i < boxTypes.size(); i++) {
            if (num_truck_left == 0) {
                return ret;
            }
            int truck_use = min(num_truck_left, boxTypes[i][0]);
            ret += (truck_use * boxTypes[i][1]);
            num_truck_left -= truck_use;
        }
        return ret;
    }
}
