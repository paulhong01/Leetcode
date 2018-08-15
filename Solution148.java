// Leetcode 148: Sort List
import java.util.*;

public class Solution148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(-1);

        Solution148 sol = new Solution148();
        ListNode res = sol.sortList(head);
        while (res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        // Method 1: MergeSort Top Down, TC:O(nlog(n)), SC:O(nlog(n))
        /* if (head == null || head.next == null)  return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid)); */

        // Method 2: MergeSort Bottom Up, TC:O(nlog(n)), SC:O(1)
        if (head == null || head.next == null)  return head;

        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }

        cur = head;
        ListNode l = new ListNode(-1);
        ListNode r = new ListNode(-1);
        ListNode tail = new ListNode(-1);
        boolean flag = true;
        ListNode[] headtail = new ListNode[2];
        headtail[0] = head;
        for (int n = 1; n < size; n <<= 1) {
            cur = head;
            flag = true;
            tail = new ListNode(-1);
            while (cur != null) {
                l = cur;
                r = split(l, n);
                cur = split(r, n);
                headtail = merge2(l, r);
                tail.next = headtail[0];
                tail = headtail[1];
                if (flag) {
                    head = headtail[0];
                    flag = false;
                }
            }
        }
        cur = head;
    
        return cur;
    }

    private ListNode[] merge2(ListNode l, ListNode r) {
        ListNode[] res = new ListNode[2];
        ListNode head;
        ListNode tail = null;
        ListNode cur;
        if (l == null || r == null) {
            head = (l != null)?l:r;
            cur = head;
            while (cur != null) {
                tail = cur;
                cur = cur.next;
            }
            res[0] = head;
            res[1] = tail;
            return res;
        } else if (l.val < r.val) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }
        cur = head;

        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        if (l != null)  cur.next = l;
        else if (r != null) cur.next = r;

        while (cur != null) {
            tail = cur;
            cur = cur.next;
        }

        res[0] = head;
        res[1] = tail;
        return res;
    }

    private ListNode split(ListNode cur, int n) {
        while (--n > 0 && cur != null) {
            cur = cur.next;
        }

        ListNode res = (cur != null)?cur.next:null;
        if (cur != null)    cur.next = null;
        return res;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 != null)?l1:l2;
        }

        ListNode head = new ListNode(-1);
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            } 
            cur = cur.next;
        }

        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;

        return head;
    }
}