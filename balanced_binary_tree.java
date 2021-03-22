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


/* ############### Top-Down Approach ##############
class Solution {
    
    public int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        
        if (root.left == null && root.right == null) 
            return 0;
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    public boolean checkBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null) {
            return true;
        }
        
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
            checkBalanced(root.left) &&
            checkBalanced(root.right);
    }
    
    public boolean isBalanced(TreeNode root) {
        
        return checkBalanced(root);
        
    }
}*/


/* 
############## Bottom-up Approach #############
*/

class HeightInfo {
    public int height;
    public boolean balanced;
    
    public HeightInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    
    public HeightInfo checkBalance(TreeNode root) {
        if (root == null) {
            return new HeightInfo(-1, true);
        }
        
        HeightInfo leftInfo = checkBalance(root.left);
        if (!leftInfo.balanced) {
            return new HeightInfo(-1, false);
        }
        
        HeightInfo rightInfo = checkBalance(root.right);
        if (!rightInfo.balanced) {
            return new HeightInfo(-1, false);
        }
        
        if (Math.abs(leftInfo.height - rightInfo.height) <= 1) {
            return new HeightInfo(Math.max(leftInfo.height, rightInfo.height) + 1, true); 
        }
        
        return new HeightInfo(-1, false);
        
    }
    
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).balanced;
    }
}


/* Notes:
 * 
 * n = number of nodes in binary tree.  
 *
 * ###### Bottom-up approach ######
 * Space Complexity: O(n) for the recursion stack
 * Time Complexity:  O(n) since we get height of each subtree & calculate height difference in constant time (levels below provide that info)
 * 
 * ###### Top-down approach #######
 * Time Complexity: O(n log n) 
 * Space Complexity: O(n)
 */
