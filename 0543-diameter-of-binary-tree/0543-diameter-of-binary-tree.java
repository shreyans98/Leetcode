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
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
        
        if(root == null)
            return 0;
        
        int left = height(root.left);
        
        int right = height(root.right);
        
        int leftDiameter = diameterOfBinaryTree(root.left);
        
        int rightDiameter = diameterOfBinaryTree(root.right);
        
        return Math.max(Math.max(leftDiameter, rightDiameter), (left+right));
        
        
        
        
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = height(root.left);
        
        int right = height(root.right);
        
        return 1+Math.max(left, right);
    }
}