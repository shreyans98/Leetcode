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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        /*
        ---------------------------Recursive Approach------------------------------------------
        
        */
        
        if(p==null && q == null)
            return true;
        
        if(p==null || q == null)
            return false;
        
        if(p.val != q.val)
            return false;
        
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        
        
        
//         Queue<TreeNode> queue = new LinkedList<>();
        
//         if(p==null && q == null)
//             return true;
        
//         if(p==null || q == null)
//             return false;
        
//         if(p != null && q != null) {
//             queue.offer(p);
//             queue.offer(q);
//         }
        
//         while(!queue.isEmpty()) {
//             TreeNode first = queue.poll();
//             TreeNode second = queue.poll();
            
//             if(first == null && second == null)
//                 continue;
            
//             if(first == null || second == null)
//                 return false;
            
//             if(first.val != second.val)
//                 return false;
            
//             queue.offer(first.left);
//             queue.offer(second.left);
//             queue.offer(first.right);
//             queue.offer(second.right);
            
//         }
//         return true;
        
    }
}