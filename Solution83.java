// Leetcode 83: Remove Duplicates from Sorted List
import java.util.*;

public class Solution83{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        Solution83 sol = new Solution83();
        head = sol.deleteDuplicates(head);
        while (head != null){
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public ListNode deleteDuplicates(ListNode head) {
        // TC:O(n), SC:O(1)
        ListNode cur = head;
        while (cur != null){
            ListNode nextlist = cur.next;
            while (nextlist != null && nextlist.val == cur.val){
                nextlist = nextlist.next;
            }
            cur.next = nextlist;
            cur = cur.next;
        }
        return head;
    }
}
