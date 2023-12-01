#include <vector>
#include <string>
#include <numeric>

class Solution {
public:
    bool arrayStringsAreEqual(std::vector<std::string>& word1, std::vector<std::string>& word2) {
        // Concatenate strings in word1
        std::string concatenatedWord1 = std::accumulate(word1.begin(), word1.end(), std::string(""));
        
        // Concatenate strings in word2
        std::string concatenatedWord2 = std::accumulate(word2.begin(), word2.end(), std::string(""));
        
        // Compare the two concatenated strings
        return concatenatedWord1 == concatenatedWord2;
    }
};
