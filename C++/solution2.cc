class Solution {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // TC:O(N1+N2), SC:O(1), N1 = length of l1, N2 = length of l2
        ListNode* dummy_head = new ListNode();
        ListNode* cur = dummy_head;
        int carry = 0;
        while (l1 != nullptr && l2 != nullptr) {
            int val = (carry + l1->val + l2->val)%10;
            carry = (carry + l1->val + l2->val)/10;
            cur->next = new ListNode(val);
            cur = cur->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        while (l1 != nullptr) {
            int val = (carry + l1->val)%10;
            carry = (carry + l1->val)/10;
            cur->next = new ListNode(val);
            cur = cur->next;
            l1 = l1->next;
        }
        
        while (l2 != nullptr) {
            int val = (carry + l2->val)%10;
            carry = (carry + l2->val)/10;
            cur->next = new ListNode(val);
            cur = cur->next;
            l2 = l2->next;
        }
        
        if (carry != 0) {
            cur->next = new ListNode(carry);
        }
        return dummy_head->next;
    }
};