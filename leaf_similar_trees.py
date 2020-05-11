# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def traverse(self, root, seq):
        if root is None:
            return
        
        self.traverse(root.left, seq)
        if root.left is None and root.right is None:
            seq.append(root.val)
        self.traverse(root.right, seq)
    
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        """
            Simple solution is to perform a pre-order traversal of both trees to get the
            sequences of leaf nodes in both trees and compare for equality.
            Time Complexity: O(m+n) where m and n are the number of nodes in tree 1 and tree 2
            The comparison of lists is done in linear time. 
            Therfore, overall complexity is linear.
        """
        seq1 = list()
        seq2 = list()
        self.traverse(root1, seq1)
        self.traverse(root2, seq2)
        if seq1 == seq2:
            return True
        else:
            return False
