/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head){
    if(!head || !head->next){
        return head;
    }
    else{
        struct ListNode*p=head;
        int temp;
        struct ListNode*q=head->next;
        while(q){
            temp=p->val;
            p->val=q->val;
            q->val=temp;
            p=q->next;

            if(p){
                q=p->next;
            }
            else{
                q=NULL;
            }
        }
    }
    return head;
}