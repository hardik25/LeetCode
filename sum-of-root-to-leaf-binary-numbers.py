# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    sum_paths = 0
    
    def traverse(self, root, path):
        
        if root and root.left is None and root.right is None:
            self.sum_paths += int(path + str(root.val), 2)
        
        if root is not None:
            path += str(root.val)
            self.traverse(root.left, path)
            self.traverse(root.right, path)
        
        
    def sumRootToLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        '''
            Using the standard pre-order traversal of tree to generate paths, using backtracking to keep paths
            Time Complexity: O(n) where n is the number of nodes in the tree
            Space Complexity: O(n) where n is the number of nodes in the tree.
        '''
        if root is None:
            return 0
        
        path = str()
        self.traverse(root, path)
        return self.sum_paths
        
