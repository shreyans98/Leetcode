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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        
        TreeNode root = buildTree(0, preorder.length-1, 0, inorder.length-1, map, preorder, inorder);
        
        return root;
        
    }
    
    public TreeNode  buildTree(int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map, 
                               int preOrder[], int inOrder[]) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preOrder[preStart]);
        
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(preStart+1, preStart+numsLeft, inStart, inRoot-1, map, preOrder, inOrder);
        
        root.right = buildTree(preStart+numsLeft+1, preEnd, inRoot+1, inEnd, map, preOrder, inOrder);
        
        return root;
        
    }
}