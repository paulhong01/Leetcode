// Leetcode 83: Remove Duplicates from Sorted List

namespace {
class Solution83 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // TC:O(N), SC:O(1)
        ListNode* cur = head;
            while (cur != nullptr) {
                while (cur->next != nullptr && cur->val == cur->next->val) {
                    cur->next = cur->next->next;
                }
                cur = cur->next;
            }
            return head;
    }
};    
}   // namespace
