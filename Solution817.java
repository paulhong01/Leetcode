// Leetcode 817: Linked List Components
import java.util.*;

public class Solution817{
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        // ListNode head = new ListNode(3);
        // head.next = new ListNode(4);
        // head.next.next = new ListNode(0);
        // head.next.next.next = new ListNode(2);
        // head.next.next.next.next = new ListNode(1);
        int[] G = {0, 3, 1, 4};
        //int[] G = {0, 1, 3};
        // int[] G = {4};
        Solution817 sol = new Solution817();
        int result = sol.numComponents(head, G);
        System.out.println(result);
    }

    public int numComponents(ListNode head, int[] G) {
        // Method 1 : Brute Force, TC:O(n1*n2), SC:O(n1), where n1 = number of elements in linked list, n2 = G.length
        /* // Record linked list element
        List<Integer> list = new ArrayList();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        // Check the element in G to the linked list element, and set the record this element as -1
        for (int i = 0; i < G.length; i++){
            for (int j = 0; j < list.size(); j++){
                if (G[i] == list.get(j)){
                    list.set(j, -1);
                    break;
                }
            }
        }
        // Get the result
        int result = list.get(0) == -1?1:0;
        for (int j = 1; j < list.size(); j++){
            if (list.get(j) == -1 && list.get(j-1) != -1){
                result++;
            }
        }
        return result; */

        // Method 2: Use hashset to record elements in G
        // TC: O(n1+n2), SC:O(n2), where n1 = number of elements in linked list, n2 = G.length
        Set<Integer> s = new HashSet();
        for(int i: G)   s.add(i);

        ListNode cur = head;
        int result = 0;
        while (cur != null){
            if (s.contains(cur.val) && (cur.next == null || !s.contains(cur.next.val))){
                result++;
            }
            cur = cur.next;
        }
        return result;
    }   
}