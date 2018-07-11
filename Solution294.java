// Leetcode 294: Flip Game II
// Description:
// You are playing the following Flip Game with your friend: 
// Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
// The game ends when a person can no longer make a move and therefore the other person will be the winner.
// Write a function to determine if the starting player can guarantee a win. 

// Example:
// Input: s = "++++"
// Output: true 
// Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
import java.util.*;

public class Solution294{
    public static void main(String[] args){
        String s = "++++";
        Solution294 sol = new Solution294();
        if (sol.canWin(s)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean canWin(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++){
            //System.out.printf("%d ", i);
            if (s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                count += 1;
            }
        }
        //System.out.printf("\n%d ", count);
        return (count % 2 == 1);
        //return helper(s.toCharArray(), 0);
    }

    // private boolean helper(char[] c, int turn){
    //     for (int i = 1; i < c.length; i++){
    //         System.out.printf("%s, Index: %d, Turn: %d\n", new String(c), i, turn);
    //         if(c[i] == '+' && c[i-1] == '+'){
    //             c[i] = '-';
    //             c[i-1] = '-';
    //             if (helper(c, turn^1)){
    //                 return true;
    //             } else {
    //                 c[i] = '+';
    //                 c[i-1] = '+';
    //             }
    //         } else if (i == c.length-1){
    //             for (int j = 1; j < c.length; j++){
    //                 if (c[j] == '+' && c[j-1] == '+'){
    //                     break;
    //                 } else if (j == c.length-1){
    //                     if (turn == 1){
    //                         return true;
    //                     } else{
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
}