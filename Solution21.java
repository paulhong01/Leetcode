//Leetcode 21: Merge Two Sorted Lists
import java.util.*;

public class Solution21{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        Solution21 sol = new Solution21();
        ListNode root = sol.mergeTwoLists(l1, l2);
        while (root != null){
            System.out.printf("%d ",root.val);
            root = root.next;
        }
        System.out.println("");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // TC:O(n1+n2), SC:O(1), where n1, n2 = number of elements in l1, l2
        if (l1 == null || l2 == null){
            return (l1==null)?l2:l1;
        }


        // Initialize head
        ListNode head, cur;
        if (l2.val < l1.val){
            head = l2;
            l2 = l2.next;
        } else{
            head = l1;
            l1 = l1.next;
        }
        cur = head;
        while (l1 != null && l2 != null){
            if (l2.val < l1.val){
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else{
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        
        if (l1 != null){
            cur.next = l1;
        } else if (l2 != null){
            cur.next = l2;
        }
        return head;
    }
}