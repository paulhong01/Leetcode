import java.util.*;

class Solution696{

    public int countBinarySubstrings(String s) {
        int first = 0, second = 0, count = 1, result = 0;

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            }else if (first == 0 && s.charAt(i) != s.charAt(i-1)){
                first = count;
                count = 1;
            }else{
                second = count;
                result += Math.min(first, second);
                first = second;
                count = 1;
            }
        }
        result += Math.min(first, count);
        return result;
    }

    public static void main(String args[]){
        String temp = "00110";
        Solution696 s = new Solution696();
        int result = s.countBinarySubstrings(temp);
        System.out.println(Integer.toString(result));
    }
}
