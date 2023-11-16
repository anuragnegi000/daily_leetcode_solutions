class Solution {
    public int romanToInt(String s) {
        // Define the Roman to Integer mapping
        HashMap<String, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put("I", 1);
        romanToInteger.put("IV", 4);
        romanToInteger.put("V", 5);
        romanToInteger.put("IX", 9);
        romanToInteger.put("X", 10);
        romanToInteger.put("XL", 40);
        romanToInteger.put("L", 50);
        romanToInteger.put("XC", 90);
        romanToInteger.put("C", 100);
        romanToInteger.put("CD", 400);
        romanToInteger.put("D", 500);
        romanToInteger.put("CM", 900);
        romanToInteger.put("M", 1000);

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            // Check for two-character Roman numeral
            if (i + 1 < s.length() && romanToInteger.containsKey(s.substring(i, i + 2))) {
                result += romanToInteger.get(s.substring(i, i + 2));
                i += 2;
            } else {
                // Single-character Roman numeral
                result += romanToInteger.get(s.substring(i, i + 1));
                i++;
            }
        }

        return result;
    }
}