public class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26]; // Assuming lowercase English letters

        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return (char) ('a' + i);
            }
        }

        // This line should not be reached if the inputs are valid
        throw new IllegalArgumentException("Invalid input strings");
    }
}