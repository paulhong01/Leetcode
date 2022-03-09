// Leetcode 82: Remove Duplicates from Sorted List II

namespace {
class Solution82 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // TC:O(N), SC:(1)
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* cur = dummy;
        while (cur != nullptr) {
            ListNode* next_node = cur->next;
            bool has_duplicated = false;
            while (next_node != nullptr && next_node->next != nullptr && (next_node->val == next_node->next->val || has_duplicated)) {
                has_duplicated = (next_node->val == next_node->next->val);
                next_node = next_node->next;
            }
            cur->next = has_duplicated?nullptr:next_node;
            cur = cur->next;
        }
        return dummy->next;
    }
};    
}   // namespace
