# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def createTree(self, nums, left, right):
        
        if left > right:
            return None
        
        middle = int(left + (right - left) / 2)
        root = TreeNode(val=nums[middle])
        root.left = self.createTree(nums, left, middle - 1)
        root.right = self.createTree(nums, middle + 1, right)
        return root
        
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.createTree(nums, 0, len(nums) -1)
