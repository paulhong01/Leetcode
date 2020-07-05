// Leetcode 441: Arranging Coins
import java.util.*;

class Solution441 {
    public int arrangeCoins(int n) {
      return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}