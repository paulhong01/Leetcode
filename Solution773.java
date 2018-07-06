// Leetcode 773: Sliding Puzzle
import java.util.*;

public class Solution773{
    public static void main(String[] args){
        //int[][] board = {{1, 2, 3},{4, 0, 5}};
        //int[][] board = {{1,2,3},{5,4,0}};
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        Solution773 sol = new Solution773();
        int result = sol.slidingPuzzle(board);
        System.out.println(Integer.toString(result));
    }

    public int slidingPuzzle(int[][] board) {
        // Map: Moving step
        Map<Integer, List<Integer>> m = new HashMap();
        m.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
        m.put(1, new ArrayList<Integer>(Arrays.asList(-1, 1, 3)));
        m.put(2, new ArrayList<Integer>(Arrays.asList(-1, 3)));
        m.put(3, new ArrayList<Integer>(Arrays.asList(-3, 1)));
        m.put(4, new ArrayList<Integer>(Arrays.asList(-3, -1, 1)));
        m.put(5, new ArrayList<Integer>(Arrays.asList(-3, -1)));

        // Transform board to string
        String s = "";
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                s += Integer.toString(board[i][j]);
            }
        }
        if (s.equals("123450"))
            return 0;
        // BFS
        Queue<String> q = new LinkedList();
        Set<String> set = new HashSet();
        q.add(s);
        set.add(s);
        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            result++;
            for (int i = 0; i < size; i++){
                String cur_string = q.poll();
                int idx_zero = cur_string.indexOf("0");
                List<Integer> step_list = m.get(idx_zero);
                for (int step: step_list){
                    // swap 
                    char[] cur = cur_string.toCharArray();
                    char temp = cur[idx_zero];
                    cur[idx_zero] = cur[idx_zero+step];
                    cur[idx_zero+step] = temp; 
                    String string_in = new String(cur);
                    if (string_in.equals("123450"))
                        return result;
                    else if (!set.contains(string_in)){
                        q.add(string_in);
                        set.add(string_in);
                    }
                }
            }
        }

        return -1;   
    }
}