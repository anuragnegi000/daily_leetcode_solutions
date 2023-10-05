/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (head == NULL) {
        return head;
    }

    struct ListNode* p1 = head->next;
    struct ListNode* p2 = head;

    while (p1 != NULL) {
        if (p2->val == p1->val) {
            p2->next = p1->next;
            free(p1); // Free the memory of the duplicate node
            p1 = p2->next; // Move p1 to the next node after the duplicate
        } else {
            p2 = p1;
            p1 = p1->next;
        }
    }

    return head;
}
