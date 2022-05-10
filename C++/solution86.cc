// Leetcode 86: Partition List

namespace {
class Solution86 {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* less_half_dummy = new ListNode(-1);
        ListNode* greater_half_dummy = new ListNode(-1);
        ListNode* less_half = less_half_dummy;
        ListNode* greater_half = greater_half_dummy;
        ListNode* cur = head;
        while (cur != nullptr) {
            if (cur->val < x) {
                less_half->next = cur;
                less_half = less_half->next;
            } else {
                greater_half->next = cur;
                greater_half = greater_half->next;
            }
            cur = cur->next;
        }
        greater_half->next = nullptr;
        less_half->next = greater_half_dummy->next;
        return less_half_dummy->next;
    }
};    
}   // namespace
