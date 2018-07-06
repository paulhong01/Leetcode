// Leetcode 657: Judge Route Circle
import java.util.*;

public class Solution657{
    public static void main(String[] args){
        //String moves = "UD";
        String moves = "LL";
        Solution657 sol = new Solution657();
        boolean result = sol.judgeCircle(moves);
        if (result){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean judgeCircle(String moves) {
        // TC:O(N), SC:O(1), where N = moves.length()
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++){
            char cur = moves.charAt(i);
            if (cur == 'U'){
                y += 1;
            } else if (cur == 'D'){
                y -= 1;
            } else if (cur == 'L'){
                x += 1;
            } else if (cur == 'R'){
                x -= 1;
            }
        }
        
        return (x == 0)&&(y == 0);
    }
}