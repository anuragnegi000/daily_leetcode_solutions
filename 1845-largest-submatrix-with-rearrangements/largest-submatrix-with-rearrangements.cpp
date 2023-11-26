#include <vector>
using namespace std;

class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        if (rows == 0) return 0;
        
        int cols = matrix[0].size();
        int result = 0;

        // Step 1: Calculate the height of each column
        vector<vector<int>> heights(rows, vector<int>(cols, 0));
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 1) {
                    heights[i][j] = (i == 0) ? 1 : heights[i - 1][j] + 1;
                }
            }
        }

        // Step 2: Sort each row in non-decreasing order
        for (int i = 0; i < rows; ++i) {
            sort(heights[i].begin(), heights[i].end(), greater<int>());
            
            // Step 3: Update the result based on the sorted heights
            for (int j = 0; j < cols; ++j) {
                result = max(result, heights[i][j] * (j + 1));
            }
        }

        return result;
    }
};
