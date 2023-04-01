// Leetcode 2586: Count the Number of Vowel Strings in Range

public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        // TC:O(N), SC:O(1)
        int num_vowel_string = 0;
        Set<Character> vowel_char = new HashSet<Character>();
        vowel_char.addAll(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        for (int i = left; i <= right; i++) {
            if (isVowelString(words[i], vowel_char)) {
                ++num_vowel_string;
            }
        }
        return num_vowel_string;
    }

    private boolean isVowelString(String word, Set<Character> vowel_char) {
        return vowel_char.contains(word.charAt(0)) && vowel_char.contains(word.charAt(word.length()-1));
    }
}
