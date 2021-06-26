#include <iostream>
#include <string>

namespace {
class Solution1904 {
public:
    int numberOfRounds(std::string startTime, std::string finishTime) {
        int start = 60*stoi(startTime.substr(0, 2))+stoi(startTime.substr(3));
        int finish = 60*stoi(finishTime.substr(0, 2))+stoi(finishTime.substr(3));
        if (finish < start) {
            finish += 60*24;
        }
        // cout << start << " " << finish << endl;
        // cout << floor(finish/15.0) << " " << ceil(start/15.0);
        return max(0, int(floor(finish/15.0)) - int(ceil(start/15.0)));
    }
};    
} // namespace
