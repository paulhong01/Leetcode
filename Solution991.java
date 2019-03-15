class Solution991 {
    public int brokenCalc(int X, int Y) {
        // TC:O(log(Y)), SC:O(1)
        int count = 0;
        while (Y > X) {
            if (Y % 2 != 0) {
                Y = (Y+1)/2;
                count+=2;
            } else {
                Y = Y/2;
                count++;
            }

        }
        count += (X-Y);
        return count;
    }
}