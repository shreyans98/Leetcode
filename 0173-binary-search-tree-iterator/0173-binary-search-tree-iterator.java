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
class BSTIterator {
    ArrayList<Integer> iterator = new ArrayList<>();
    int counter = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root.left);
        iterator.add(root.val);
        inorder(root.right);
        return;
    }
    
    public int next() {
        return iterator.get(counter++);
    }
    
    public boolean hasNext() {
        if(counter != iterator.size())
            return true;
        else
            return false;
        
        
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */