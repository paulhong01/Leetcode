// Leetcode 17: Letter Combinations of a Phone Number
import java.util.*;

public class Solution17 {
    public static void main(String[] args) {
        String digits = "";

        Solution17 sol = new Solution17();
        List<String> res = sol.letterCombinations(digits);
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        // Backtracking, OC:(3^n), TC:O(n)
        int len = digits.length();
        List<String> result = new ArrayList();
        if (len == 0) {
            return result;
        }
        boolean[][] check = new boolean[len][4];
        String[] collections = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder temp = new StringBuilder();
        backtracking(result, temp, check, 0, digits, collections);
        return result;
    }

    private void backtracking(List<String> result, StringBuilder temp, boolean[][] check, int idx, String digits, String[] collections) {
        if (temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }

        int currentdigit = (int)(digits.charAt(idx) - '0') - 2;
        String col = collections[currentdigit];
        for (int i = 0; i < col.length(); i++) {
            if (!check[idx][i]) {
                temp.append(col.charAt(i));
                check[idx][i] = true;
                backtracking(result, temp, check, idx + 1, digits, collections);
                temp.deleteCharAt(temp.length() - 1);
                check[idx][i] = false;
            }
        }
    }
}