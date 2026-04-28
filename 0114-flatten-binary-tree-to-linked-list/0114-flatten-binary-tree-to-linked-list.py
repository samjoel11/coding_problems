# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def dfs(node):
            if not node:
                return

            dfs(node.left)
            dfs(node.right)
            temp = node.right

            node.right = node.left
            node.left = None

            t = node
            while t.right:
                t = t.right

            t.right = temp

        dfs(root)