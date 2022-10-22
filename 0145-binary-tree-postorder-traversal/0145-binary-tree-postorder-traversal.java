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
    public List<Integer> postorderTraversal(TreeNode root) {
        
//         List<Integer> post = new ArrayList<>();
        
//         if(root ==null)
//             return post;
        
//         post.addAll(postorderTraversal(root.left));
//         post.addAll(postorderTraversal(root.right));
        
//         post.add(root.val);
        
//         return post;
        
        
        
//         List<Integer> post = new ArrayList<Integer>();
        
//         Stack<TreeNode> st1 = new Stack<TreeNode>();
//         Stack<TreeNode> st2 = new Stack<TreeNode>();
        
//         if(root == null)
//             return post;
        
//         st1.push(root);
        
//         while(!st1.isEmpty()) {
//             root = st1.pop();
//             st2.push(root);
            
//             if(root.left != null)
//                 st1.push(root.left);
            
//             if(root.right != null)
//                 st1.push(root.right);
                
            
//         }
        
//         while(!st2.isEmpty())
//             post.add(st2.pop().val);
        
//         return post;
        
        
        
        /*
        //using 1 stack
        
        =====================================================================================
        
        */  
        
        
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root == null)
            return res;
        
        TreeNode curr = root;
    
        
        while(curr != null || !st.isEmpty()) {
            
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            
            else {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.peek();
                    st.pop();
                    res.add(temp.val);
                    
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        res.add(temp.val);
                    }
                    
                }
                else
                    curr = temp;
            }
            
        }
        
        return res;
        
        
        
        
        
        
    }
}