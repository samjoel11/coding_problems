class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = maxproduct = minproduct = nums[0]
        for n in nums[1:]:
            maxproduct, minproduct = max(n, maxproduct*n, minproduct*n), min(n, maxproduct*n, minproduct*n)
            res = max(res, maxproduct)
        return res