# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    '''
    Approach 1: Perform an inorder traversal of the binary search tree which returns a sorted array, and return k-1 element
    Time Complexity: O(n) where n is the number of nodes 
    Space Complexity: O(n) where n is the number of nodes
    
    def traverse(self, root, traversal):
        
        if not root:
            return 
        
        self.traverse(root.left, traversal)
        traversal.append(root.val)
        self.traverse(root.right, traversal)
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        traversal = list()
        self.traverse(root, traversal)
        return traversal[k - 1]
    '''     
    
    def  kthSmallest(self, root, k):
        '''
            Approach 2: Using an iterative approach using stack. 
            Time Complexity: O(log n + k) where n is the number of nodes in tree, and K is the input.
            Space Complexity: O(log n + k) same as above.
        '''
        stack = list()
        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k = k - 1
            if not k:
                return root.val
            root = root.right
