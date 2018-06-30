//Leetcode 763: Partition Labels
import java.util.*;

public class Solution763{
    public static void main(String args[]){
        String S = "ababcbacadefegdehijhklij";
        Solution763 s = new Solution763();
        List<Integer> result = s.partitionLabels(S);
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String S) {
        // Use map, TC: O(N) SC: O(1), where N = s.length()
        int location[] = new int[26];
        Arrays.fill(location, -1);

        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            location[c-'a'] = i;
        }

        int max = 0;
        int origin = 0;
        List<Integer> result = new ArrayList();
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if (location[c-'a'] == i && i == max){
                result.add(max - origin + 1);
                max++;
                origin = i+1;
            }else if (location[c-'a'] > max){
                max = location[c-'a'];
            }
        }

        return result;
    }
}