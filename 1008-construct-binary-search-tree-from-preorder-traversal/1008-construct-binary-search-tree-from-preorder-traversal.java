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
Bound approach can be followed, where when we go to the left of the root then the root value becomes the max bound and when we move to the right then INT_MAX becomes the bound.

SInce we cannot have pass by refrence in java that's why we have a single element array which is the index of the tree


*/
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MAX_VALUE, new int[]{0}); 
        
    }
    
    public TreeNode solve(int A[], int bound, int[] i) {
        if(i[0] == A.length || A[i[0]]>bound)
            return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = solve(A, root.val, i);
        root.right = solve(A, bound, i);
        return root;
    }
}