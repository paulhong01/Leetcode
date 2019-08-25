// Leetcode 380: Insert Delete GetRandom O(1)
import java.util.*;

class RandomizedSet {
    List<Integer> list = new ArrayList();
    Map<Integer, Integer> map = new HashMap();
    Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int last_num = list.get(list.size()-1);
        int cur_idx = map.get(val);
        list.set(cur_idx, last_num);
        map.put(last_num, cur_idx);
        map.remove(new Integer(val));
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}