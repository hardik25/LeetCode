# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    '''
        Recursive pre-order traversal of tree. 
        Time Complexity: O(n) where n is the number of nodes in the tree
        Space Complexity: O(n)
    '''
    left_sum = 0
    def calculateSum(self, root):
        
        if root is None:
            return 
        
        if root.left is None and root.right is None:
            return 
    
        self.calculateSum(root.left)
        if (root.left is not None and root.left.left is None and root.left.right is None):
            self.left_sum += root.left.val
        self.calculateSum(root.right)
    
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        self.calculateSum(root)
        return self.left_sum
