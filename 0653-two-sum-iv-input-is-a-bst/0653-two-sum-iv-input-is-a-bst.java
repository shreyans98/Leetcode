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
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        
        int i=0, j = nums.size()-1;
        
        while(i<j) {
            if((nums.get(i) + nums.get(j)) > k)
                j--;
            else if((nums.get(i) + nums.get(j)) < k)
                i++;
            else
                return true;
        }
        return false;
        
    }
    
    public void inorder(TreeNode root, List<Integer> nums) {
        if(root == null)
            return;
        
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}