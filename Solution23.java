// Leetcode 23: Merge k Sorted Lists
import java.util.*;

public class Solution23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        Solution23 sol = new Solution23();
        ListNode res = sol.mergeKLists(lists);
        while (res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
    }

    private int minvalue(ListNode[] lists) {
        int min_idx = -1, min_value = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min_value) {
                min_value = lists[i].val;
                min_idx = i;
            }
        }
        return min_idx;
    }

    private boolean checkvalid(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int idx = minvalue(lists);
        if (idx == -1)
            return null;
        ListNode head = lists[idx];
        lists[idx] = lists[idx].next;
        ListNode cur = head;

        while (checkvalid(lists)) {
            idx = minvalue(lists);
            cur.next = lists[idx];
            lists[idx] = lists[idx].next;
            cur = cur.next;
        }

        return head;
    }
}