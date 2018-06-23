import java.util.*;

class Solution18{
    public static void main(String args[]){
        int num[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Solution18 s = new Solution18();
        s.fourSum(num, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                int v1 = nums[i], v2 = nums[j], v3, v4;
                int front = j + 1, back = nums.length - 1;
                while (front < back){
                    v3 = nums[front];
                    v4 = nums[back];
                    if (v1 + v2 + v3 + v4 < target)
                        front++;
                    else if (v1 + v2 + v3 + v4 > target)
                        back--;
                    else{
                        result.add(Arrays.asList(v1,v2,v3,v4));
                        front++;
                        back--;

                        while (front < back && nums[front] == v3)   front++;
                        while (front < back && nums[back] == v4)    back--;
                    }
                }
                while (j+1 < nums.length && nums[j+1] == v2)    j++;
            }
            while(i+1 < nums.length && nums[i+1] == nums[i])    i++;
        }

        return result;
    } 
}