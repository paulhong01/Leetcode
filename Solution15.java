import java.util.*;

public class Solution15{
    public static void main(String args[]){
        int []nums = {-1, 0, 1, 2, -1, -4};
        Solution15 s = new Solution15();
        s.threesum(nums);
    }

    public List<List<Integer>> threesum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<> ();

        for (int i = 0; i + 2 < nums.length; i++){
            int v1 = nums[i];
            int front = i + 1, back = nums.length - 1;
            while (front < back){
                if (v1+nums[front]+nums[back] == 0){
                    res.add(Arrays.asList(nums[i], nums[front], nums[back]));
                    front++;
                    back--;

                    while (front < back && nums[front] == nums[front-1])    front++;
                    while (back > front && nums[back] == nums[back+1])  back--;
                }else if (v1 + nums[front] + nums[back] < 0){
                    front++;
                }else{
                    back--;
                }
            }
            while (i+1 < nums.length && nums[i+1] == nums[i])   i++;
        }

        return res;
    }
}