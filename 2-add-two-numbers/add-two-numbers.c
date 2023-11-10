struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* result = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* ptr = result;

    int carry = 0; // Set default carry

    while (l1 != NULL || l2 != NULL) {
        int sum = 0 + carry; // Initialize sum

        if (l1 != NULL) { // Use number from first list
            sum += l1->val;
            l1 = l1->next;
        }

        if (l2 != NULL) { // Use number from 2nd list
            sum += l2->val;
            l2 = l2->next;
        }

        carry = sum / 10; // Get sum and carry
        sum = sum % 10;

        ptr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
        ptr->next->val = sum;
        ptr->next->next = NULL;
        ptr = ptr->next;
    }

    if (carry == 1) {
        ptr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
        ptr->next->val = 1;
        ptr->next->next = NULL;
    }

    return result->next;
}