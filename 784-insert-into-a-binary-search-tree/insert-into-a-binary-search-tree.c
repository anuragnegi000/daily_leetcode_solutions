/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {
    struct TreeNode*t,*parent;
    t=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    t->val=val;
    t->left=NULL;
    t->right=NULL;
    parent=root;
    if(root==NULL){
        root=t;
    }
    else{
        struct TreeNode*curr;
        curr=root;
        while(curr){
            parent=curr;
            if(t->val>curr->val){
                curr=curr->right;
            }
            else{
                curr=curr->left;
            }
        }
        if(t->val>parent->val){
            parent->right=t;
        }
        else{
            parent->left=t;
        }
    }
    return root;
    
}