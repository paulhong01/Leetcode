// Leetcode 2816: Double a Number Represented as a Linked List

class Solution2816 {
    public ListNode doubleIt(ListNode head) {
        // TC:O(N), SC:O(1)
        ListNode new_head = reverseList(head);
        
        int carry = 0;
        ListNode cur = new_head;
        while (true) {
            int new_val = (cur.val*2 + carry);
            cur.val = (new_val)%10;
            carry = new_val/10;

            if (cur.next == null) {
                if (carry != 0) {
                    cur.next = new ListNode(carry);
                }
                break;
            }
            cur = cur.next;
        }
       
        return reverseList(new_head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode origin_next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = origin_next;
        }
        return prev;
    }
}
