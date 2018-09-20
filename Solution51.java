// Leetcode 51: N-Queens
import java.util.*;

public class Solution51 {
    public static void main(String[] args) {
        int n = 4;

        Solution51 sol = new Solution51();
        List<List<String>> res = sol.solveNQueens(n);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] record = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                record[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(record, 0, res);
        return res;
    }

    private void dfs(char[][] record, int colindx, List<List<String>> result) {
        if (colindx == record.length) {
            result.add(construct(record));
            return;
        }

        for (int i = 0; i < record.length; i++) {
            if (validate(record, i, colindx)) {
                record[i][colindx] = 'Q';
                dfs(record, colindx + 1, result);
                record[i][colindx] = '.';
            }
        }
    }

    private boolean validate(char[][] record, int x, int y) {
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < y; j++) {
                if (record[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] record) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < record.length; i++) {
            String s = new String(record[i]);
            res.add(s);
        }
        return res;
    }
}