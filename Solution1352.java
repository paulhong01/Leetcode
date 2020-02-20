// Leetcode 1352: Product of the Last K Numbers
import java.util.*;

class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if (num != 0) {
            list.add(list.get(list.size()-1)*num);
        } else {
            list = new ArrayList();
            list.add(1);
        }
    }
    
    public int getProduct(int k) {
        int N = list.size();
        return k < N?list.get(N-1)/list.get(N-k-1):0;
    }
}
