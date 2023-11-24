#include <vector>
#include <algorithm>

class Solution {
public:
    int maxCoins(std::vector<int>& piles) {
        int n = piles.size();
        
        // Sort the piles in descending order.
        std::sort(piles.begin(), piles.end(), std::greater<int>());
        
        int result = 0;
        int rounds = n / 3;
        
        // Pick every second element starting from the second element.
        for (int i = 1; i <= 2 * rounds; i += 2) {
            result += piles[i];
        }
        
        return result;
    }
};
