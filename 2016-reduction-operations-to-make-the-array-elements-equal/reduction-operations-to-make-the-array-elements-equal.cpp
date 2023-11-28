#include <vector>
#include <algorithm>

class Solution {
public:
    int reductionOperations(std::vector<int>& nums) {
        // Sort the array in descending order
        std::sort(nums.begin(), nums.end(), std::greater<int>());

        int operations = 0;
        int current = nums[0];  // Initialize with the largest value
        int currentCount = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < current) {
                current = nums[i];
                currentCount = i;
                operations += currentCount;
            }
        }

        return operations;
    }
};
