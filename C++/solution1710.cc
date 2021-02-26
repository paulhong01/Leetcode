// Leetcode 1710: Maximum Units on a Truck
#include <iostream>
#include <vector>

namespace {

class Solution {
public:
    int maximumUnits(std::vector<std::vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](const std::vector<int>& box_a, const std::vector<int> box_b){
           return box_a[1] > box_b[1]; 
        });
        int ret = 0;
        int num_truck_left = truckSize;
        for (int i = 0; i < boxTypes.size(); i++) {
            if (num_truck_left == 0) {
                return ret;
            }
            int truck_use = std::min(num_truck_left, boxTypes[i][0]);
            ret += (truck_use * boxTypes[i][1]);
            num_truck_left -= truck_use;
        }
        return ret;
    }
};

} // namespace