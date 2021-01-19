#include <iostream>
#include <vector>

class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        int max_len = 0;
        int ret_num = 0;
        for (const vector<int>& rectangle : rectangles) {
            int min_side = std::min(rectangle[0], rectangle[1]);
            if (min_side > max_len) {
                ret_num = 1;
                max_len = min_side;
            } else if (min_side == max_len) {
                ret_num++;
            }
        }
        return ret_num;
    }
};