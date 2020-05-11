# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def merge(self, t1, t2):
        if t1 is None:
            return t2
        
        if t2 is None:
            return t1
        
        
        return TreeNode(t1.val + t2.val, self.merge(t1.left, t2.left), self.merge(t1.right, t2.right))
        
    
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        
        """
            Simple Solution is to traverse the 2 trees, creating a new node and repeating the
            process for left and right subtrees. 
            Time Complexity: O(m+n) where m and n are the number of nodes in 2 trees.
        """
        return self.merge(t1, t2)
