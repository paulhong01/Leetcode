//Leetcode 206: Reverse Linked List
import java.util.*;

public class Solution206{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution206 sol = new Solution206();
        head = sol.reverseList(head);
        ListNode cur = head;
        while (cur != null){
            System.out.printf("%d ", cur.val);
            cur = cur.next;
        }
        System.out.println("");
    }

    public ListNode reverseList(ListNode head) {
        // Method 1: Iterative, Create an arraylist
        // TC:O(n), SC:O(n), where n = number of elements in linked list
        /* List<Integer> l = new ArrayList();
        ListNode cur = head;
        while (cur != null){
            l.add(cur.val);
            cur = cur.next;
        }

        Collections.reverse(l);
        cur = head;
        int idx = 0;
        while (cur != null){
            cur.val = l.get(idx++);
            cur = cur.next;
        }
        return head; */

        // Method 2: Iterative, change the pointer's direction
        // TC:O(n), SC:O(1)
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode nextnode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextnode;
        }

        return prev; 

        // Method 3: Recursive
        // TC:O(n), SC:O(n)
        //return traversal(null, head);
        
    }

    private ListNode traversal(ListNode prev, ListNode cur){
        if (cur == null){
            return prev;
        }

        ListNode newhead = traversal(cur, cur.next);
        cur.next = prev;
        return newhead;
    }
}