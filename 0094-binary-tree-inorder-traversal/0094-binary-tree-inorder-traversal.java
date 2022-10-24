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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.left == null) {//parent node is accessed
                inorder.add(curr.val);
                curr=curr.right;
            }
            
            else {
                TreeNode prev = curr.left;
                
                while(prev.right != null && prev.right != curr) {//travel upto the right most element
                    prev = prev.right;
                }
                
                if(prev.right == null) {//connecing the thread (right most element of left sub tree with current element)
                    prev.right = curr;
                    curr = curr.left;
                }
                
                else {
                    prev.right = null;//disconnect the above thread
                    inorder.add(curr.val);//inorder will take the value as it will be the root node now
                    curr = curr.right;
                }
            }
        }
        return inorder;
        
        
        
        
        
        
        
//         List<Integer> in = new ArrayList<Integer>();
        
//         if(root ==null)
//             return in;
        
//         in.addAll(inorderTraversal(root.left));
//         in.add(root.val);
//         in.addAll(inorderTraversal(root.right));
        
//         return in;
        
        
        
          /*
          
          Iterative Approach
          
          */
        
        
//         List<Integer> in = new ArrayList<>();
        
//         Stack<TreeNode> st = new Stack<TreeNode>();
        
//         TreeNode curr = root;
        
//         while(curr != null || !st.isEmpty()) {
            
//             while(curr != null) {
//                 st.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = st.pop();
//             in.add(curr.val);
//             curr = curr.right;
//         }
        
//         return in;
        
        
    }
}