// Leetcode 2807: Insert Greatest Common Divisors in Linked List

class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // TC:O(N), SC:O(1)
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode origin_next = cur.next;
            cur.next = new ListNode(GetGcd(cur.val, origin_next.val));
            cur.next.next = origin_next;
            cur = origin_next;
        }
        return head;
    }

    private int GetGcd(int val1, int val2) {
        for (int i = Math.min(val1, val2); i >= 1; i--) {
            if (val1 % i == 0 && val2 % i == 0) {
                return i;
            }
        }
        return 1;
    } 
}
