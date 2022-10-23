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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        //Do level order traversal and print only the last element of that level for right view
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int num = queue.size();
            
            for(int i=0;i<num;i++) {
                TreeNode curr = queue.peek();
                queue.remove();
                
                if(curr.left != null)
                    queue.offer(curr.left);
                
                if(curr.right != null)
                    queue.offer(curr.right);
                
                if(i == num-1)
                    list.add(curr.val);
                
            }
        }
        
        return list;
        
    }
}