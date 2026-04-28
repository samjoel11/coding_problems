class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        l = max(nums)
        r = sum(nums)
        while l <= r:
            mid = l + (r - l) // 2
            curr = self.helper(nums, mid)
            if curr > k:
                l = mid + 1
            else:
                r = mid - 1
        return l
    def helper(self, nums, mid):
        k = 1
        sum = 0
        for i in nums:
            if sum + i <= mid:
                sum += i
            else:
                sum = i
                k += 1
        return k

