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

/*
Here, we leverage the fact that Inorder Traversal of a BST gives a sorted list of elements.
If there are exactly 2 swapped nodes, we can check the mistake in the inorder traversal.
For eg.,
root = [6,2,5,null,null,null,3]
Inorder traversal: [2,6,5,3] (Not sorted).

First incorrect node/element is 6 because 6 > 5 (first == null && prev > curr) => prev is the first node.
Second incorrect node/element is 3, because 5 > 3 (first != null && prev > curr), curr is the second node.
To cover the edge-case of 2 consecutive elements to be swapped, we always assign second = curr.
*/
class Solution {
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        
        swapNode(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
    public void swapNode(TreeNode curr) {
        if(curr == null)
            return;
        
        swapNode(curr.left);
        if(prev != null && prev.val > curr.val) {
            if(first == null)
                first = prev;
            second = curr;
        }
        
        prev = curr;
        swapNode(curr.right);
    }
}