// Leetcode 2785: Sort Vowels in a String

class Solution2785 {
    public String sortVowels(String s) {
        // TC:O(NLogN), SC:O(N)
        int N = s.length();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Character> vows = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (!isVowel(s.charAt(i))) {
                continue;
            }
            pos.add(i);
            vows.add(s.charAt(i));
        }

        Collections.sort(vows);

        char[] ret = s.toCharArray();
        for (int i = 0; i < pos.size(); i++) {
            ret[pos.get(i)] = vows.get(i);
        }
        return new String(ret);
    }

    private boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
