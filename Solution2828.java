// Leetcode 2828: Check if a String Is an Acronym of Words

class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        // TC:O(N), SC:O(N), N = words.length
        StringBuilder first_words = new StringBuilder();
        for (String word : words) {
            first_words.append(word.charAt(0));
        }
        return first_words.toString().equals(s);
    }
}
