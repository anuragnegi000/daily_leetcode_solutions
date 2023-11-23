#include <vector>
#include <algorithm>

class Solution {
public:
    bool isArithmetic(std::vector<int>& arr) {
        if (arr.size() < 2) {
            return true;
        }

        std::sort(arr.begin(), arr.end());

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.size(); ++i) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    std::vector<bool> checkArithmeticSubarrays(std::vector<int>& nums, std::vector<int>& l, std::vector<int>& r) {
        int numQueries = l.size();
        std::vector<bool> result;

        for (int i = 0; i < numQueries; ++i) {
            int left = l[i];
            int right = r[i];
            std::vector<int> subarray(nums.begin() + left, nums.begin() + right + 1);

            result.push_back(isArithmetic(subarray));
        }

        return result;
    }
};
