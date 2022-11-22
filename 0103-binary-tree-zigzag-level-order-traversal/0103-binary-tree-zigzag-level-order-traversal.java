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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        Queue<TreeNode> level = new LinkedList<>();
        
        List<List<Integer>> zig = new LinkedList<List<Integer>>();
        
        if(root == null)
            return zig;
        
        level.offer(root);
        
        boolean flag = true;
        
        while(!level.isEmpty()) {
            int size = level.size();
            
            List<Integer> subList = new LinkedList<>();
            
            for(int i=0;i<size;i++) {
                if(level.peek().left != null)
                    level.offer(level.peek().left);
                
                if(level.peek().right != null)
                    level.offer(level.peek().right);
                
                if(flag == true)
                    subList.add(level.poll().val);
                else
                    subList.add(0, level.poll().val);
                
            }
            
            flag = !flag;
            zig.add(subList);
        }
        
        return zig;
        
    }
}