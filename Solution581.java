class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortarray = nums.clone();
        Arrays.sort(sortarray);
        int startidx = 0, endidx  = nums.length-1;
        
        while (startidx < nums.length - 1) {
            if (nums[startidx] != sortarray[startidx])  break;
            else startidx++;
        }
        
        while (endidx >= startidx) {
            if (nums[endidx] != sortarray[endidx]) break;
            else endidx--;
        }
        
        return endidx - startidx + 1;
    }
}