// Leetcode 138: Copy List with Random Pointer
import java.util.*;

public class Solution138 {
    private Map<RandomListNode, RandomListNode> map = new HashMap();
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        else if (map.containsKey(head)) {
            return map.get(head);
        }
        
        RandomListNode cur = new RandomListNode(head.label);
        map.put(head, cur);
        cur.next = copyRandomList(head.next);
        cur.random = copyRandomList(head.random);
        
        
        return cur;
    }
}