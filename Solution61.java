// Leetcode 61: Rotate List
import java.util.*;

class Solution61 {
    // arraylist, go through the list and store in the arraylist
    // k = k % arraylist.size()
    // newhead = index(arraylist.size() - k)
    // index(arraylist.size() - k - 1)->next = NULL;
    // index(arraylist.size() - 1)->next = head
    public ListNode rotateRight(ListNode head, int k) {
        // One pass:TC:O(n), SC:O(n)
        List<ListNode> list = new ArrayList();
        if (head == null)   return null;
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        
        int listsize = list.size();
        k = k % list.size();
        if (listsize - k == 0 || k == 0)  return head;
        ListNode newhead = list.get(listsize - k);
        list.get(listsize - k - 1).next = null;
        list.get(listsize - 1).next = head;
        return newhead;
    }
}