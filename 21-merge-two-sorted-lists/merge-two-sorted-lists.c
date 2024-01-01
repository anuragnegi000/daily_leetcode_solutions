/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

#include <stdlib.h>

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode* p1 = list1;
    struct ListNode* p2 = list2;
    struct ListNode* head = NULL;
    struct ListNode* current = NULL;

    while (p1 != NULL && p2 != NULL) {
        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        if (newNode == NULL) {
            // Handle memory allocation failure
            return NULL;
        }

        if (p1->val < p2->val) {
            newNode->val = p1->val;
            p1 = p1->next;
        } else {
            newNode->val = p2->val;
            p2 = p2->next;
        }

        newNode->next = NULL;

        if (head == NULL) {
            head = newNode;
            current = head;
        } else {
            current->next = newNode;
            current = newNode;
        }
    }

    // If one of the lists is not empty, append the remaining nodes
    if (p1 != NULL) {
        if (head == NULL) {
            head = p1;
        } else {
            current->next = p1;
        }
    } else if (p2 != NULL) {
        if (head == NULL) {
            head = p2;
        } else {
            current->next = p2;
        }
    }

    return head;
}
