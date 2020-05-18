// Leetcode 1451: Rearrange Words in a Sentence
import java.util.*;

class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        Arrays.sort(arr, (a, b)-> a.length() - b.length());
        String ans = String.join(" ", arr);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }
}