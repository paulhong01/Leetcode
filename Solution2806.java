// Leetcode 2806: Account Balance After Rounded Purchase

class Solution806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        // TC:O(1), SC:O(1)
        return 100 - (purchaseAmount+5)/10*10;
    }
}
