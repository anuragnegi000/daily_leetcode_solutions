/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int countNodes(struct TreeNode* root) {
    int x,y;
    if(root!=NULL){
        x=countNodes(root->left);
        y=countNodes(root->right);

        return x+y+1;
    }
    return 0;
}