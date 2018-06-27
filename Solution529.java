// Leetcode 529: Minesweeper
import java.util.*;

class Solution529 {
    private boolean[][] visited;
    public char[][] updateBoard(char[][] board, int[] click) {
        // TC:O(MN) SC:O(1)
        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        visited = new boolean[board.length][board[0].length];
        board = traversal(board, click[0], click[1]);
        return board;
    }
    
    public char[][] traversal(char[][] board, int x, int y){
        int checker = check(board, x, y);
        if (checker != 0){
            board[x][y] = (char)(checker + '0');
            return board;
        }
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if (x+i < 0 || x+i >= board.length || y+j < 0 || y+j >= board[0].length){
                    continue;
                }else if (!visited[x+i][y+j]){
                    visited[x+i][y+j] = true;
                    board[x+i][y+j] = 'B';
                    board = traversal(board, x+i, y+j);
                }
            }
        }
        return board;
    }
    
    public int check(char[][] board, int x, int y){
        int check = 0;
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <=1; j++){
                if (x+i < 0 || x+i >= board.length || y+j < 0 || y+j >= board[0].length){
                    continue;
                }else if (board[x+i][y+j] == 'M'){
                    check++;
                }
            }
        }
        return check;
    }
}