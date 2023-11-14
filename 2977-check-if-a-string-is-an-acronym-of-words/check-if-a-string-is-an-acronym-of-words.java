public class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (words == null || words.isEmpty() || s == null || s.isEmpty()) {
            return false;
        }

        StringBuilder acronym = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                acronym.append(word.charAt(0));
            }
        }

        return s.equalsIgnoreCase(acronym.toString());
    }
}