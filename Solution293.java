// Leetcode 293: Flip Game
// Problem Description:
// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
// you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

import java.util.*;

class Solution293 {
    public static void main(String[] args) {
        String s = "++++";
        Solution293 sol = new Solution293();
        List<String> res = sol.generatePossibleNextMoves(s);
        for (String r: res) {
            System.out.println(r);
        }
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList();
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i-1) == '+') {
                String flip = s.substring(0, i-1) + "--" + s.substring(i+1);
                result.add(flip);
            } 
        }
        return result;
    }
}