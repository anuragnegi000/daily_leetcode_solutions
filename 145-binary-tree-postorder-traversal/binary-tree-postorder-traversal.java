/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 import java.util.List;
 import java.util.ArrayList;
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        Postorder(root,result);
        return result;
    }
    private void Postorder(TreeNode node,List<Integer>result){
        if(node!=null){
            Postorder(node.left,result);//Go to left most
            Postorder(node.right,result);//Go to right most
            result.add(node.val);//add the root in result list at last
        }
    }
}