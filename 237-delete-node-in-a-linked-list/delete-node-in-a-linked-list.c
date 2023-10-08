/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
    
    struct ListNode*p1=node;
    struct ListNode*p2=node;
    while(p1->next!=NULL){
        p2=p1;
        p1->val=p1->next->val;
        p1=p1->next;
    }
    p2->next=NULL;
}