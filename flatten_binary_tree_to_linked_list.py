# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    '''
     Recursive Solution, most intuitive 
     Time Complexity: O(n) 
     Space Complexity: O(n) -> System Stack is used
    
     def flattenTree(self, root):
        
        if not root:
            return None
        
        if not root.left and not root.right:
            return root
        
        leftTail = self.flattenTree(root.left)
        rightTail = self.flattenTree(root.right)
        
        if leftTail:
            leftTail.right = root.right
            root.right = root.left
            root.left = None
            
        if rightTail:
            return rightTail
        else:
            return leftTail
        
        
        
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.flattenTree(root)
    '''
    
    def flatten(self, root):
        
        '''
            Space efficient solution using Morris Traversal (Greedy Approach)
            We "rightify" the tree progressively.
            The greedy part here to find the rightmost node for current left subtree, but not actual rightmost
            We take care to rightify the resulting tree in further iterations. We terminate iteration when we
            have a complete right skewed tree and have reached None. 
            
            Time Complexity: O(n)
            Space Complexity: O(1)
        '''
        
        if not root:
            return None
        
        node = root
        while node:
            
            if  node.left:
                
                rightmost = node.left
                while rightmost.right:
                    rightmost = rightmost.right
                
                rightmost.right = node.right
                node.right = node.left
                node.left = None
            
            node = node.right
            
