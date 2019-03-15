// Leetcode 1006: Clumsy Factorial
import java.util.*;

class Solution1006 {
    public int clumsy(int N) {
        List<Integer> list = new ArrayList();
        for (int i = N; i >= 1; i -= 4) {
            int temp;
            if (i >= 4) {
                temp = (int)Math.floor(i*(i-1)/(double)(i-2));
                list.add(temp);
                list.add(i-3);
            } else if (i >= 3) {
                temp = (int)Math.floor(i*(i-1)/(double)(i-2));
                list.add(temp);
            } else if (i >= 2) {
                list.add(i*(i-1));
            } else if (i == 1) {
                list.add(i);
            }
        }
        
        int result = list.get(0);
        for (int i = 1; i < list.size(); i+=2) {
            if (i+1 < list.size()) {
                result += list.get(i);
                result -= list.get(i+1);
            } else {
                result += list.get(i);
            }
        }
        return result;
    }
} 