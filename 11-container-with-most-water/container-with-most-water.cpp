#include <vector>
#include <algorithm>

class Solution {
public:
    int maxArea(std::vector<int>& height) {
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            // Calculate the area between the current left and right pointers
            int h = std::min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            // Update max area if the current area is greater
            maxArea = std::max(maxArea, area);

            // Move the pointers towards the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
};
