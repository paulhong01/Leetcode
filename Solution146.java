// Leetcode 146: LRU Cache
import java.util.*;

class LRUCache {
    List<Integer> list;
    int size = 0;
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        size = capacity;
        list = new ArrayList();
        map = new HashMap();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            if (value != -1) {
                list.remove(new Integer(key));
                list.add(key);
            }
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        int checkvalue = map.getOrDefault(key, -1);
        if (checkvalue != -1) {
            list.remove(new Integer(key));
            list.add(key);
        } else if (list.size() == size) {
            int oldkey = list.get(0);
            map.put(oldkey, -1);
            list.remove(0);
            list.add(key);
        } else {
            list.add(key);
        }
        map.put(key, value);
    }
}