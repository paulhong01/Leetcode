//Leetcode 725: Split Linked List in Parts
import java.util.*;

public class Solution725{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        int k = 2;
        Solution725 sol = new Solution725();
        ListNode[] res = sol.splitListToParts(head, k);
        for (ListNode l: res){
            ListNode cur = l;
            while (cur != null){
                System.out.printf("%d ", cur.val);
                cur = cur.next;
            }
            System.out.printf(", ");
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        // TC:O(N), SC:O(1), where N = number of elements in linked list
        ListNode[] result = new ListNode[k];
        if (root == null)
            return result;
        ListNode cur = root;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }

        
        cur = root;
        ListNode temptail = null;
        for (int i = 0; i < k; i++){
            ListNode temphead = cur;

            int numperarray = (int)Math.ceil(count/(float)(k-i));
            count -= numperarray;
            for (int j = 0; (j < numperarray)&& cur!=null; j++){
                temptail = cur;
                cur = cur.next;
            }
            
            temptail.next = null;
            result[i] = temphead;
            
        }
        return result;
    }
}