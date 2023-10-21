struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (!head || !head->next || k == 0) {
        return head;
    }

    struct ListNode* p1 = head;
    int len = 1;

    // Find the length of the linked list
    while (p1->next) {
        p1 = p1->next;
        len++;
    }

    // Move p1 to the head and calculate the new position for p1
    p1->next = head;
    k = k % len;  // Handle cases where k is larger than len

    // Find the new tail (p2) and the new head (head)
    struct ListNode* p2 = head;
    for (int i = 0; i < len - k - 1; i++) {
        p2 = p2->next;
    }

    head = p2->next;
    p2->next = NULL;

    return head;
}
