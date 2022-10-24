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
    int count = 0;
    int result = Integer.MAX_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }
    
    private void helper(TreeNode root, int k) {
        if(root == null)
            return;
        
        helper(root.left, k);
        count++;
        if(count == k)
            result = root.val;
        
        helper(root.right, k);
    }
}