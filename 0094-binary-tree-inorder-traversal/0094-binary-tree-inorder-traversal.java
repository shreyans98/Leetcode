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
        
        
        List<Integer> in = new ArrayList<>();
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        TreeNode curr = root;
        
        while(curr != null || !st.isEmpty()) {
            
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            
            curr = st.pop();
            in.add(curr.val);
            curr = curr.right;
        }
        
        return in;
        
        
    }
}