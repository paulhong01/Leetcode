//Leetcode 445: Add Two Numbers II
import java.util.*;

public class Solution445{
    public static void main(String[] args){
        // ListNode l1 = new ListNode(7);
        // l1.next = new ListNode(2);
        // l1.next.next = new ListNode(4);
        // l1.next.next.next = new ListNode(3);
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(7);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        Solution445 sol = new Solution445();
        ListNode reshead = sol.addTwoNumbers(l1, l2);
        while (reshead != null){
            System.out.printf("%d ", reshead.val);
            reshead = reshead.next;
        }
        System.out.println("");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Method 1: Store value in string, then convert to int to addition
        // Problem: Exceed integer 32 bits
        // TC:O(n1 + n2 + nr), SC:O(1)
        // Convert numbers in l1, l2 to String
        /* String l1s = "";
        String l2s = "";
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null){
            l1s += Integer.toString(cur1.val);
            l2s += Integer.toString(cur2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null){
            l1s += Integer.toString(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null){
            l2s += Integer.toString(cur2.val);
            cur2 = cur2.next;
        }

        // Convert the addition result to linked list
        int result = Integer.parseInt(l1s) + Integer.parseInt(l2s);
        int length = Integer.toString(result).length();
        int div = (int)Math.pow(10,length-1);
        ListNode head = new ListNode(result/div);
        result %= div;
        cur1 = head;
        for (int i = length-2; i >= 0; i--){
            div = (int)Math.pow(10, i);
            cur1.next = new ListNode(result/div);
            result %= div;
            cur1 = cur1.next;
        }

        return head; */

        // Method 2: Use stack
        // TC:O(n1 + n2 + nr), SC:O(n1 + n2)
        Stack<Integer> s1 = new Stack();
        ListNode cur = l1;
        while (cur != null){
            s1.add(cur.val);
            cur = cur.next;
        }

        Stack<Integer> s2 = new Stack();
        cur = l2;
        while (cur != null){
            s2.add(cur.val);
            cur = cur.next;
        }

        int sum = 0;
        ListNode result = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.isEmpty())  sum += s1.pop();
            if (!s2.isEmpty())  sum += s2.pop();
            result.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = result;
            result = head;
        }
        return result.val == 0?result.next:result;
    }
}