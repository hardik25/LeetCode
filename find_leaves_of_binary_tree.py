# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def traverse(self, node, parent, leaves):
        
        
        if node and node.left is None and node.right is None:
            leaves.append(node.val)
            if parent.left is node:
                parent.left = None
            if parent.right is node:
                parent.right = None
        
        if node.left:
            self.traverse(node.left, node, leaves)
        if node.right:
            self.traverse(node.right, node, leaves)
        
        
    
    def findLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        
        '''
            Solution is a recursive approach where we use backtracking using a parent pointer. 
            Time Complexity: O(n^2) where n is the number of nodes in the tree
            Space Complexity: O(n^2) where n is the number of nodes in the tree
        '''
        result = list()
        if root is None:
            return result
        
        while root.left is not None or root.right is not None:
            parent = None
            leaves = list()
            self.traverse(root, parent, leaves)
            result.append(leaves)
        last_element = [root.val]
        result.append(last_element)
        return result
