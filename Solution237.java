//Leetcode 237: Delete Node in a Linked List
import java.util.*;

public class Solution237{
    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        Solution237 sol = new Solution237();
        sol.deleteNode(head.next);
        ListNode temp = head;
        while (temp != null){
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
    }

    public void deleteNode(ListNode node) {
        // TC:O(1), SC:O(1)
        node.val = node.next.val;
        node.next = node.next.next;
    }
}