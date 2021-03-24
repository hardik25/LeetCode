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

/* ########## Recursive Approach ###########

class Solution {
    
    public TreeNode performInverse(TreeNode root) {
        if (root == null)
            return null;
        
        if (root.left == null && root.right == null)
            return root;
        
        TreeNode newTreeNode = new TreeNode(root.val);
        newTreeNode.right = performInverse(root.left);
        newTreeNode.left = performInverse(root.right);
        return newTreeNode;
    }
    
    public TreeNode invertTree(TreeNode root) {      
        return performInverse(root);     
    }
}
*/

/* ########## Iterative Approach ############
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null)
            return null;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) {
                queue.add(node.left);
            }
            
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}

/* Notes:
 * 
 * n = number of nodes in binary tree.  
 * Space Complexity: O(n) for the stack recursion in recursive solution, and queue size in iterative solution. 
 * Time Complexity:  O(n) since we have to traverse each node at least once. 
 *   
 */
