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
    public int goodNodes(TreeNode root) {

        return solve1(root, root.val);
   
    }
    
    public int solve1(TreeNode root, int value) {
        
        if(root == null)
            return 0;
        
        value = Math.max(value, root.val);
        
        return ((root.val >= value ? 1 : 0) + (solve1(root.left, value)) + (solve1(root.right, value)));
        
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int solve(TreeNode root, int mini) {

        if(root == null)
            return 0;
        
        mini = Math.max(mini, root.val);

        return (root.val >= mini ? 1 : 0) + solve(root.left, mini) + solve(root.right, mini);
    }
}