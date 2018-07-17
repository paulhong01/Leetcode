//Leetcode 2: Add Two Numbers
import java.util.*;

public class Solution2{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        Solution2 sol = new Solution2();
        ListNode res = sol.addTwoNumbers(l1, l2);
        while (res != null){
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println("");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TC:O(n1 + n2), SC:O(max(n1+n2)), where n1, n2 = number of elements in l1, l2
        // Initialize
        int sum = 0;
        sum += (l1.val) + (l2.val);
        ListNode head = new ListNode(sum%10);
        ListNode cur = head;
        sum /= 10;
        l1 = l1.next;
        l2 = l2.next;

        // Sum
        while (l1 != null && l2 != null){
            sum += (l1.val) + (l2.val);
            cur.next = new ListNode(sum%10); 
            sum /= 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        // Remaining linked list
        ListNode remain = (l1 == null)?l2:l1;
        if (remain != null){
            cur.next = remain;
            sum += remain.val;
            remain.val = sum % 10;
            sum /= 10;
            while (sum != 0){
                if (remain.next != null){
                    sum += remain.next.val;
                    remain.next.val = sum % 10;
                } else {
                    remain.next = new ListNode(sum);
                }
                remain = remain.next;
                sum /= 10;
            }
        }else if (remain == null && sum != 0){
            cur.next = new ListNode(sum);
        }

        return head;
    }
}